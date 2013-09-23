package no.foodelicious.service;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.yammer.metrics.annotation.Timed;

@Path("recipe/create")
public class RecipeCreateResource {
	
	@POST
	@Timed
	public void createRecipe(Recipe recipe){
		
	}

}
