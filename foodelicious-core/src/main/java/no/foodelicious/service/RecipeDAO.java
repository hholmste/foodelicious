package no.foodelicious.service;

import java.util.ArrayList;
import java.util.Collection;

import javax.ws.rs.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Optional;

public class RecipeDAO {

    private static final Logger LOG = LoggerFactory.getLogger(RecipeDAO.class);

    private static RecipeDAO instance;
    private final Collection<Recipe> recipes = new ArrayList<>();
    private long counter = 2;
    private Recipe defaultRecipe = new Recipe(1, "Pizza", "Kjøp grandis på rema - husk ketchup.");

    private RecipeDAO() {
        recipes.add(defaultRecipe);
    }

    public static RecipeDAO getInstance() {
        return instance != null ? instance : new RecipeDAO();
    }

    public Recipe create(Recipe recipe) {
        recipe.setId(counter++);
        recipes.add(recipe);
        return recipe;
    }

    public Optional<Recipe> findById(@PathParam("id") Long id) {
        for (Recipe recipe : recipes) {
            if (recipe.getId() == id.longValue()) {
                return Optional.of(recipe);
            }
        }
        return Optional.absent();
    }

    public Collection<Recipe> findAll() {
        LOG.debug("findAll called " + recipes);
        return recipes;
    }
}