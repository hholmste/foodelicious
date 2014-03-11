package no.foodelicious.core.repository;

import java.util.List;

import no.foodelicious.core.model.Recipe;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;

public class RecipeRepository {
	
	private Datastore ds;
	
	public RecipeRepository(Datastore ds){
		this.ds = ds;
	}
	
	public Recipe create(Recipe recipe){
		ds.save(recipe);
		return recipe;
	}
	
	public Recipe findById(ObjectId id){
		return ds.get(Recipe.class, id);
	}
	
	public List<Recipe> findAll(){
		return ds.find(Recipe.class).asList();
	}

	public void delete(Recipe recipe) {
		ds.delete(recipe);
	}
}