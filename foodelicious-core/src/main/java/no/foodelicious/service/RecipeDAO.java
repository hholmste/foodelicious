package no.foodelicious.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.PathParam;


import com.google.common.base.Optional;

public class RecipeDAO {
	
	private static RecipeDAO instance;
	private final Map<Long, Optional<Recipe>> recipes = new HashMap<>();
	private long counter;
	private Recipe defaultRecipe;

	
	private RecipeDAO(){
		defaultRecipe = new Recipe(counter++, "Pizza", "Kjøp grandis på rema - husk ketchup.");
		recipes.put(1L, Optional.of(defaultRecipe));
	}
	
	public static RecipeDAO getInstance(){
		return instance != null ? instance : new RecipeDAO();
	}

	public Optional<Recipe> create(Recipe recipe) {
		long key = counter++;
		recipes.put(key, Optional.of(recipe));
		return recipes.get(key);
	}
	
	public Optional<Recipe> findById(@PathParam("id") Long id) {
		return recipes.get(id);
    }
	
	public Collection<Optional<Recipe>> findAll(){
		System.out.println("findAll called " + recipes.values());
		return recipes.values();
	}
}