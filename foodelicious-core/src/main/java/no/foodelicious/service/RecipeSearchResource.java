package no.foodelicious.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.common.base.Optional;
import com.yammer.metrics.annotation.Timed;

@Path("/recipe/{id}")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class RecipeSearchResource {
	
	private RecipeDAO recipeDao = RecipeDAO.getInstance();
    
    @GET
    @Timed
    public Optional<Recipe> getRecipe(@PathParam("id") Long id) {
        return recipeDao.findById(id);
    }
}
