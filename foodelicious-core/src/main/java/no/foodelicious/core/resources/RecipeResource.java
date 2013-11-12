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

import no.foodelicious.core.model.Recipe;
import no.foodelicious.core.repository.RecipeRepository;

import org.mongodb.morphia.Key;

import com.yammer.metrics.annotation.Timed;

@Path("/recipe")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class RecipeResource {

	private RecipeRepository repository;
	
	public RecipeResource() {
		repository = new RecipeRepository();
	}

	@GET
	@Timed
	public Collection<Recipe> getRecipe() {
		return repository.findAll();
	}

	@GET
	@Timed
	@Path("/{id}")
	public Recipe getRecipe(@PathParam("id") Long id) {
		return repository.findById(id);
	}

	@POST
	public Response createRecipe(Recipe recipe){
		Key<Recipe> createdRecipe = repository.create(recipe);
		return Response.status(Response.Status.CREATED).entity(createdRecipe)
				.build();
	}
}
