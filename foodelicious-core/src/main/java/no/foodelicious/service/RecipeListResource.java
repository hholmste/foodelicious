package no.foodelicious.service;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.yammer.metrics.annotation.Timed;

@Path("/recipe")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class RecipeListResource {
    
    private RecipeDAO racipeDao = RecipeDAO.getInstance();

    @GET
    @Timed
    public Collection<Recipe> getRecipe() {
        return racipeDao.findAll();
    }
}
