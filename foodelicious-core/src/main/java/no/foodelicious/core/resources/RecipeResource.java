package no.foodelicious.core.resources;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import no.foodelicious.core.dao.RecipeDAO;
import no.foodelicious.service.Recipe;

import com.google.common.base.Optional;
import com.yammer.metrics.annotation.Timed;

@Path("/recipe")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class RecipeResource {

    private RecipeDAO recipeDao = RecipeDAO.getInstance();

    @GET
    @Timed
    public Collection<Recipe> getRecipe() {
        return recipeDao.findAll();
    }
    
    @GET
    @Timed
    @Path("/{id}")
    public Optional<Recipe> getRecipe(@PathParam("id") Long id) {
        return recipeDao.findById(id);
    }

    @POST
    public Response createRecipe(Recipe recipe) {
        Recipe createdRecipe = recipeDao.create(recipe);
        return Response.status(Response.Status.CREATED).entity(createdRecipe).build();
    }
}
