package no.foodelicious.core.resources;


import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSInputFile;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

@Path("/image")
public class ImageResource {

	private final GridFS gridFs;

	public ImageResource(GridFS gridFs) {
		this.gridFs = gridFs;
	}

	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response image(@FormDataParam("file") InputStream inputStream, @FormDataParam("file") FormDataContentDisposition fileDetail) {
		try {
			GridFSInputFile file = gridFs.createFile(inputStream, fileDetail.getFileName());
			file.save();
			return Response.ok(file.getId().toString()).build();
		} catch (Exception e) {
			return Response.serverError().build();
		}

	}

//	@GET
//	@Path("/{id}")
//	@Consumes
//	public Response findById(@PathParam("id") final String id) throws Exception {
//		GridFSDBFile gridFSDBFile = gridFs.findOne(new ObjectId(id));
//		
//		ImageStreamingOutput out = new ImageStreamingOutput();
//		
//		return Response.ok().build();
//	}
}