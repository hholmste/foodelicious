package no.foodelicious.core;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import no.foodelicious.core.configuration.MongoConfiguration;
import no.foodelicious.core.factory.RepositoryFactory;
import no.foodelicious.core.matchers.RecipeMatcher;
import no.foodelicious.core.model.Recipe;
import no.foodelicious.core.repository.RecipeRepository;

import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;

/**
 * This class needs a mongo database running at localhost on port 27017.
 */
public class RecipeRepositoryIntegrationTest {

	private RecipeRepository repository;

	@Before
	public void setup() {
		repository = new RepositoryFactory().create(new MongoConfiguration("localhost", 27017, "databaseName"));
	}

	@Test
	public void insertVerifyAndRemove() throws Exception {
		Recipe recipe = RecipeObjectMother.create();
		Recipe key = repository.create(recipe);

		ObjectId recipeId = (ObjectId) key.getId();
		Recipe retrievedRecipe = repository.findById(recipeId);
		assertThat(retrievedRecipe, notNullValue());
		assertThat(recipe, RecipeMatcher.isEqualTo(retrievedRecipe));

		repository.delete(retrievedRecipe);

		Recipe shouldBeNull = repository.findById(recipeId);
		assertThat(shouldBeNull, nullValue());
	}
}
