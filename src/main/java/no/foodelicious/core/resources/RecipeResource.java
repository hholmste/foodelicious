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

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yammer.metrics.annotation.Timed;

@Path("/recipe")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class RecipeResource {
	private static final Logger LOG = LoggerFactory.getLogger(RecipeResource.class);

	private RecipeRepository repository;
	
	public RecipeResource(RecipeRepository repository) {
		this.repository = repository;
	}

	@GET
	@Timed
	public Collection<Recipe> getRecipe() {
		return repository.findAll();
	}

	@GET
	@Timed
	@Path("/{id}")
	public Recipe getRecipe(@PathParam("id") ObjectId id) {
		Recipe recipe = repository.findById(id);
		LOG.debug(String.format("Found %s for [id=%s].", recipe, id));
		return recipe;
	}

	@POST
	public Response createRecipe(Recipe recipe){
		Recipe createdRecipe = repository.create(recipe);
		LOG.debug(String.format("Created recipe with id: [id=%s][machine=%s][timeSecond=%s][inc=%s].", createdRecipe.getId(), createdRecipe.getId().getMachine(), createdRecipe.getId().getTimeSecond(), createdRecipe.getId().getInc()));
		Response response = Response.status(Response.Status.CREATED).entity(createdRecipe).build();
		return response;
	}
}