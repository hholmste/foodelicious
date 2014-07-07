package no.foodelicious.core.resources;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.fest.assertions.api.Assertions.assertThat;
import io.dropwizard.jackson.Jackson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import no.foodelicious.core.model.CourseType;
import no.foodelicious.core.model.Ingredient;
import no.foodelicious.core.model.MeasuringUnit;
import no.foodelicious.core.model.Recipe;
import no.foodelicious.core.model.RecipeItem;

import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RecipeParseTest {
	private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

	private String normalizedJson;
	
	@Before
	public void setup() throws IOException {
		normalizedJson = MAPPER.writeValueAsString(MAPPER.readValue(fixture("fixtures/recipe.json"), JsonNode.class));
	}

	@Test
	public void producesTheExpectedJson() throws Exception {
		Recipe recipe = creatRecipe();
		assertThat(MAPPER.writeValueAsString(recipe))
			.isEqualTo(normalizedJson)
			.as("rendering a recipe as JSON produces a valid API representation");
	}

	@Test
	@Ignore
	public void consumesTheExpectedJson() throws Exception {
		Recipe recipe = creatRecipe();
		assertThat(MAPPER.readValue(fixture("fixtures/recipe.json"), Recipe.class))
			.isEqualTo(recipe)
			.as("parsing a valid API representation produces a recipe");
	}

	private Recipe creatRecipe() {
		Recipe recipe = new Recipe();
		recipe.setId(new ObjectId("5320c5e50364bb7b16ca3546"));
		recipe.setName("Pizza");
		recipe.setDescription("Some description");
		recipe.setDirections("Some directions");
		recipe.setServings(2);
		recipe.setCourseType(CourseType.DINNER);
		recipe.setRecipeItems(creatRecipeItems());
		recipe.setSource("www.someplace.com");
		recipe.setImageId("abc");
		recipe.setIngredients("Some ingredients");
		return recipe;
	}

	private List<RecipeItem> creatRecipeItems() {
		List<RecipeItem> items = new ArrayList<RecipeItem>();
		Ingredient ingredient = new Ingredient();
		ingredient.setId(1);
		ingredient.setName("Tomato");
		ingredient.setDescription("Ingredient description");
		RecipeItem item = new RecipeItem();
		item.setIngredient(ingredient);
		item.setNumber(2);
		item.setMeasuringUnit(MeasuringUnit.Kilograms);
		
		item.setIngredient(ingredient);
		items.add(item);
		return items;
	}

}
