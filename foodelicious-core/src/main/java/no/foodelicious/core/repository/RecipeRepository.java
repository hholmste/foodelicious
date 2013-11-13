package no.foodelicious.core.repository;

import java.util.List;

import no.foodelicious.core.model.Recipe;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;

public class RecipeRepository {
	
	private Datastore ds;
	
	public RecipeRepository(Datastore ds){
		this.ds = ds;
	}
	
	public Key<Recipe> create(Recipe recipe){
		return ds.save(recipe);
	}
	
	public Recipe findById(Long id){
		return ds.get(Recipe.class, id);
	}
	
	public List<Recipe> findAll(){
		return ds.find(Recipe.class).asList();
	}
}