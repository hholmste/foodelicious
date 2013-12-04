package no.foodelicious.core.factory;

import java.net.UnknownHostException;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.gridfs.GridFS;

import no.foodelicious.core.configuration.MongoConfiguration;
import no.foodelicious.core.model.Recipe;
import no.foodelicious.core.repository.RecipeRepository;

public class RepositoryFactory {
	
	private MongoClient mongoClient;

	public RecipeRepository create(MongoConfiguration config){
		return new RecipeRepository( getDatatore(config));
	}
	
	public GridFS createGridFS(MongoConfiguration config){
		Mongo mongo = getDatatore(config).getMongo();
		DB db = mongo.getDB("foodelicious");
		GridFS gridFS = new GridFS(db);
		return gridFS;
	}
	
	public Datastore getDatatore(MongoConfiguration config){
		try {
			mongoClient = new MongoClient(config.getUrl(), config.getPort());
			return new Morphia()
			.map(Recipe.class)
			.createDatastore(mongoClient, "foodelicious");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return null;
	}
}