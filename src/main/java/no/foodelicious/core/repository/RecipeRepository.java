package no.foodelicious.core.repository;

import java.util.List;

import no.foodelicious.core.model.Recipe;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;

public class RecipeRepository implements Repository<Recipe> {
	
	private Datastore ds;
	
	public RecipeRepository(Datastore ds){
		this.ds = ds;
	}
	
	@Override
	public Recipe create(Recipe recipe){
		ds.save(recipe);
		return recipe;
	}
	
	@Override
	public Recipe findById(ObjectId id){
		return ds.get(Recipe.class, id);
	}
	
	@Override
	public List<Recipe> findAll(){
		return ds.find(Recipe.class).asList();
	}

	@Override
	public void delete(Recipe recipe) {
		ds.delete(recipe);
	}
}