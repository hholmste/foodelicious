package no.foodelicious.core.resources;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

import no.foodelicious.core.model.ImageMeta;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.BasicDBObject;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

@Path("/image")
public class ImageResource {
	private final static Logger LOG = LoggerFactory.getLogger(ImageResource.class);

	private final GridFS gridFs;

	public ImageResource(GridFS gridFs) {
		this.gridFs = gridFs;
	}

	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response image(@FormDataParam("file") InputStream inputStream,
			@FormDataParam("file") FormDataContentDisposition fileDetail) {
		try {
			GridFSInputFile file = gridFs.createFile(inputStream, fileDetail.getFileName());
			file.save();
			return Response.ok(file.getId().toString()).build();
		} catch (Exception e) {
			return Response.serverError().build();
		}

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<ImageMeta> images() throws Exception {
		List<ImageMeta> imagemetas = new ArrayList<>();
		List<GridFSDBFile> files = gridFs.find(new BasicDBObject());
		for (GridFSDBFile file : files) {
			imagemetas.add(new ImageMeta(file.getId().toString(), file.getFilename()));
		}
		return imagemetas;
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public Response findById(@PathParam("id") final String id) throws Exception {
		LOG.debug(String.format("Retrieving file with [id=%s]", id));
		final GridFSDBFile gridFSDBFile = gridFs.findOne(new ObjectId(id));
		LOG.debug(String.format("Found [GridFSDBFile=%s]", gridFSDBFile));

		StreamingOutput stream = new StreamingOutput() {
			@Override
			public void write(OutputStream output) throws IOException, WebApplicationException {
				try {
					gridFSDBFile.writeTo(output);
				} catch (Exception e) {
					throw new WebApplicationException(e);
				}
			}
		};

		return Response.ok(stream)
				.header(String.format("content-disposition", "attachment; filename = %s"), gridFSDBFile.getFilename())
				.build();
	}
}