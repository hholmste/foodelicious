package no.foodelicious.core.resources;

import java.io.InputStream;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.sun.jersey.core.header.FormDataContentDisposition;

@Path("/recipeimgupload")
public class RecipeImageUploadResource {
	
	@POST
	public Response uploadImage(InputStream inputStream, FormDataContentDisposition disposition){
		
		return Response.status(200).build();
	}

}
