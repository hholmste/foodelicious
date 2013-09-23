package no.foodelicious.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.common.base.Optional;

@Path("recipe/create")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RecipeCreateResource {
	
	private RecipeDAO recipeDao = RecipeDAO.getInstance();
	
	@POST
	public Optional<Recipe> createRecipe(Recipe recipe){
		return recipeDao.create(recipe);
	}

}
