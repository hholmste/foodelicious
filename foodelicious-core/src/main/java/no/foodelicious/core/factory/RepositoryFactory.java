package no.foodelicious.core.factory;

import java.net.UnknownHostException;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;

import no.foodelicious.core.configuration.MongoConfiguration;
import no.foodelicious.core.model.Recipe;
import no.foodelicious.core.repository.RecipeRepository;

public class RepositoryFactory {
	
	private MongoClient mongoClient;

	public RecipeRepository create(MongoConfiguration config){
		return new RecipeRepository( getDatatore(config));
	}
	
	private Datastore getDatatore(MongoConfiguration config){
		try {
			mongoClient = new MongoClient(config.getHost(), config.getPort());
			return new Morphia()
			.map(Recipe.class)
			.createDatastore(mongoClient, "foodelicious");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return null;
	}
}