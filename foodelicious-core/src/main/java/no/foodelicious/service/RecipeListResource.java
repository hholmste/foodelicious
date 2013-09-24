package no.foodelicious.service;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.yammer.metrics.annotation.Timed;

@Path("/recipe")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class RecipeListResource {

    private RecipeDAO recipeDao = RecipeDAO.getInstance();

    @GET
    @Timed
    public Collection<Recipe> getRecipe() {
        return recipeDao.findAll();
    }

    @POST
    public Response createRecipe(Recipe recipe) {
        Recipe createdRecipe = recipeDao.create(recipe);
        return Response.status(Response.Status.CREATED).entity(createdRecipe).build();
    }
}
