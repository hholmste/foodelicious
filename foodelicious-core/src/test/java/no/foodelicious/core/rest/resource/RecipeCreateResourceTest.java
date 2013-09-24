package no.foodelicious.core.rest.resource;

import javax.ws.rs.core.MediaType;

import org.junit.Test;
import static org.fest.assertions.api.Assertions.assertThat;

import no.foodelicious.service.Recipe;
import no.foodelicious.service.RecipeResource;

import com.yammer.dropwizard.testing.ResourceTest;

public class RecipeCreateResourceTest extends ResourceTest {

    @Override
    protected void setUpResources() throws Exception {
        addResource(new RecipeResource());
    }

    @Test
    public void testCreateRecipe() {
        Recipe recipe = new Recipe(99L);
        assertThat(client().resource("/recipe").type(MediaType.APPLICATION_JSON).post(Recipe.class, recipe).equals(recipe));
    }
}