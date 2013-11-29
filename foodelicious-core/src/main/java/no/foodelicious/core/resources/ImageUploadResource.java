package no.foodelicious.core.resources;

import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.bson.types.ObjectId;

import com.mongodb.QueryBuilder;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;

@Path("/imageupload")
@Consumes(MediaType.MULTIPART_FORM_DATA + ";charset=utf-8")
@Produces(MediaType.MULTIPART_FORM_DATA + ";charset=utf-8")
public class ImageUploadResource {

	private GridFS gridFs;

	public ImageUploadResource(GridFS gridFs) {
		this.gridFs = gridFs;
	}

	@POST
	public Response uploadImage(InputStream inputStream) {
		GridFSInputFile file = gridFs.createFile(inputStream);
		return Response.ok(file.getId().toString()).build();
	}

	@GET
	@Path("/{id}")
	public GridFSDBFile findById(String id) {
		return gridFs.findOne(QueryBuilder.start("_id").is(new ObjectId(id))
				.get());
	}
}
