package no.foodelicious.core.resources;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.junit.Assert.*;

import javax.ws.rs.core.MediaType;

import no.foodelicious.core.configuration.MongoConfiguration;
import no.foodelicious.core.factory.RepositoryFactory;
import no.foodelicious.core.matchers.RecipeMatcher;
import no.foodelicious.core.model.Recipe;

import org.junit.Test;

import com.yammer.dropwizard.testing.ResourceTest;

public class RecipeResourceTest extends ResourceTest {

	@Override
	protected void setUpResources() throws Exception {
		addResource(new RecipeResource(new RepositoryFactory().create(new MongoConfiguration("localhost", 27017))));
	}

	@Test
	public void testCreateAndGetRecipe() {
		Recipe originalRecipe = new Recipe();
		originalRecipe.setName("Grandiosa");
		originalRecipe.setDescription("Sett på stekeovn");
		originalRecipe.setServings(1);
		originalRecipe.setSource("www.vg.no");
		Recipe createdRecipe = client().resource("/recipe").type(MediaType.APPLICATION_JSON).post(Recipe.class, originalRecipe);
		assertThat(createdRecipe.getId()).isNotNull();

		Recipe retrievedRecipe = client().resource("/recipe/" + createdRecipe.getId()).get(Recipe.class);
		assertEquals(retrievedRecipe, RecipeMatcher.isEqualTo(originalRecipe));
	}
}