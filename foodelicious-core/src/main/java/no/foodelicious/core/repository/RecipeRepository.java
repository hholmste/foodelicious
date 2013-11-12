package no.foodelicious.core.repository;

import java.net.UnknownHostException;
import java.util.List;

import no.foodelicious.core.model.Recipe;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.Morphia;

import com.mongodb.Mongo;

public class RecipeRepository {
	
	private Datastore ds;
	
	public RecipeRepository(){
		ds = getDatatore();
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
	
	
	private Datastore getDatatore(){
		try {
			return new Morphia()
			.map(Recipe.class)
			.createDatastore(new Mongo("localhost", 27017), "foodelicious");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return null;
	}
}