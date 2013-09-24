package no.foodelicious.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("recipe/create")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class RecipeCreateResource {
	
	private RecipeDAO recipeDao = RecipeDAO.getInstance();
	
	@POST
	public Response createRecipe(Recipe recipe){
	    Recipe createdRecipe = recipeDao.create(recipe);
		return Response.status(Response.Status.CREATED).entity(createdRecipe).build();
	}

}
