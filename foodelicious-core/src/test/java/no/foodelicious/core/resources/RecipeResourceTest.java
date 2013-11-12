package no.foodelicious.core.resources;

import javax.ws.rs.core.MediaType;

import org.junit.Test;
import static org.fest.assertions.api.Assertions.assertThat;

import no.foodelicious.core.model.Recipe;
import no.foodelicious.core.resources.RecipeResource;

import com.yammer.dropwizard.testing.ResourceTest;

public class RecipeResourceTest extends ResourceTest {

    @Override
    protected void setUpResources() throws Exception {
        addResource(new RecipeResource());
    }

    @Test
    public void testCreateRecipe() {
        Recipe recipe = new Recipe();
        recipe.setName("Grandiosa");
        recipe.setDescription("Sett på stekeovn");
        recipe.setServings(1);
        recipe.setSource("www.vg.no");
        assertThat(client().resource("/recipe").type(MediaType.APPLICATION_JSON).post(Recipe.class, recipe).equals(recipe));
    }
}