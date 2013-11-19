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

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.QueryBuilder;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;
import com.sun.jersey.core.header.FormDataContentDisposition;

@Path("/imageupload")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class ImageUploadResource {
	
	private GridFS gridFs;
	
	public ImageUploadResource(GridFS gridFs) {
		this.gridFs = gridFs;
	}

	@POST
	public Response uploadImage(InputStream inputStream, FormDataContentDisposition disposition){
		
		DBObject metaData = new BasicDBObject();
		metaData.put("filename", disposition.getFileName());
		metaData.put("contentType", disposition.getType());
		
		GridFSInputFile file = gridFs.createFile(inputStream);
		
		return Response.ok(file.getId().toString()).build();
	}
	
	@GET
	@Path("/{id}")
	public GridFSDBFile findById(String id){
		return gridFs.findOne(QueryBuilder.start("_id").is(new ObjectId(id)).get());
	}
}
