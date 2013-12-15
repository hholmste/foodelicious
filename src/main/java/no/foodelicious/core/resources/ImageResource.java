package no.foodelicious.core.resources;

import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.bson.types.ObjectId;

import com.google.common.base.Optional;
import com.mongodb.BasicDBObject;
import com.mongodb.QueryBuilder;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;

@Path("/image")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class ImageResource {

	private GridFS gridFs;

	public ImageResource(GridFS gridFs) {
		this.gridFs = gridFs;
	}

	@POST
	public Response uploadImage(InputStream inputStream) {
		GridFSInputFile file = gridFs.createFile(inputStream);
		return Response.ok(file.getId().toString()).build();
	}

	@GET
	@Path("/{id}")
	public Response findById(@PathParam("id") final String id) throws Exception {
		GridFSDBFile gridFSDBFile = gridFs.findOne(new ObjectId(id));

		
		ImageStreamingOutput out = new ImageStreamingOutput();
		
		return Response.ok().build();
	}
}