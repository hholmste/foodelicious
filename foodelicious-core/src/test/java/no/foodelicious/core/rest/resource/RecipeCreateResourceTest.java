package no.foodelicious.core.rest.resource;

import org.junit.Test;
import static org.fest.assertions.api.Assertions.assertThat;

import no.foodelicious.service.Recipe;
import no.foodelicious.service.RecipeCreateResource;

import com.yammer.dropwizard.testing.ResourceTest;

public class RecipeCreateResourceTest extends ResourceTest{

	@Override
	protected void setUpResources() throws Exception {
        addResource(new RecipeCreateResource());
	}
	
	@Test
	public void testCreateRecipe(){
		Recipe recipe = new Recipe(99L);
		assertThat(client().resource("/recipe/create/").post(Recipe.class).equals(recipe));
		
	}
}