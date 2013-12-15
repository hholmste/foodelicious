package no.foodelicious.core.resources;

import static com.yammer.dropwizard.testing.JsonHelpers.asJson;
import static com.yammer.dropwizard.testing.JsonHelpers.fromJson;
import static com.yammer.dropwizard.testing.JsonHelpers.jsonFixture;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

import java.util.ArrayList;
import java.util.List;

import no.foodelicious.core.model.CourseType;
import no.foodelicious.core.model.Ingredient;
import no.foodelicious.core.model.MeasuringUnit;
import no.foodelicious.core.model.Recipe;
import no.foodelicious.core.model.RecipeItem;

import org.junit.Ignore;
import org.junit.Test;

public class RecipeParseTest {

	@Test
	@Ignore
	public void producesTheExpectedJson() throws Exception {
		Recipe recipe = creatRecipe();
		assertThat(
				"rendering a recipe as JSON produces a valid API representation",
				asJson(recipe), equalTo(jsonFixture("fixtures/recipe.json")));
	}
	
	@Test
	@Ignore
	public void consumesTheExpectedJson() throws Exception {
		Recipe recipe = creatRecipe();
	    assertThat("parsing a valid API representation produces a recipe",
	               fromJson(jsonFixture("fixtures/recipe.json"), Recipe.class),
	               equalTo(recipe));
	}

	private Recipe creatRecipe() {
		Recipe recipe = new Recipe();
		recipe.setName("Pizza");
		recipe.setDescription("Some description");
		recipe.setDirections("Some directions");
		recipe.setServings(2);
		recipe.setCourseType(CourseType.MAIN_COURSE);
		recipe.setRecipeItems(creatRecipeItems());
		recipe.setSource("www.someplace.com");
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
