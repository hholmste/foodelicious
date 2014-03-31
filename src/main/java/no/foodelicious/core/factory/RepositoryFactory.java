package no.foodelicious.core.factory;

import java.net.UnknownHostException;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.gridfs.GridFS;

import no.foodelicious.core.configuration.MongoConfiguration;
import no.foodelicious.core.model.Recipe;
import no.foodelicious.core.repository.RecipeRepository;

public class RepositoryFactory {

	private static final Logger LOG = LoggerFactory.getLogger(RepositoryFactory.class);

	private MongoClient mongoClient;

	public RecipeRepository create(MongoConfiguration config){
		return new RecipeRepository( getDatatore(config));
	}
	
	public GridFS createGridFS(MongoConfiguration config){
		Mongo mongo = getDatatore(config).getMongo();
		DB db = mongo.getDB(config.getDatabase());
		GridFS gridFS = new GridFS(db);
		return gridFS;
	}
	
	public Datastore getDatatore(MongoConfiguration config){
		try {
			LOG.debug(String.format("Connecting to mongo database at %s:%d", config.getUrl(), config.getPort()));
			mongoClient = new MongoClient(config.getUrl(), config.getPort());
			return new Morphia()
			.map(Recipe.class)
			.createDatastore(mongoClient, config.getDatabase());
		} catch (UnknownHostException e) {
			LOG.error(String.format("Error connecting to mongo database at %s:%d", config.getUrl(), config.getPort(), config.getDatabase()), e);
		}
		return null;
	}
}