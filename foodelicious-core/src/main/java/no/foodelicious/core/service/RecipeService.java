package no.foodelicious.core.service;

import no.foodelicious.core.configuration.RecipeConfiguration;
import no.foodelicious.core.factory.RepositoryFactory;
import no.foodelicious.core.health.MongoHealth;
import no.foodelicious.core.resources.ImageResource;
import no.foodelicious.core.resources.RecipeResource;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

public class RecipeService extends Service<RecipeConfiguration> {

	public static void main(String[] args) throws Exception {
		new RecipeService().run(args);
	}

	@Override
	public void initialize(Bootstrap<RecipeConfiguration> bootstrap) {
		bootstrap.setName("foodelicious");
	}

	@Override
	public void run(RecipeConfiguration configuration, Environment environment)throws Exception {
		// resources goes here
		environment.addResource(new RecipeResource(new RepositoryFactory().create(configuration.getMongoConfig())));
		environment.addResource(new ImageResource(  new RepositoryFactory().createGridFS( configuration.getMongoConfig() )));
		//configure request/response logging
		environment.setJerseyProperty(ResourceConfig.PROPERTY_CONTAINER_REQUEST_FILTERS, LoggingFilter.class);
		environment.setJerseyProperty(ResourceConfig.PROPERTY_CONTAINER_RESPONSE_FILTERS, LoggingFilter.class);

		// health checks goes here
		environment.addHealthCheck(new MongoHealth(new RepositoryFactory().getDatatore(configuration.getMongoConfig()).getMongo()));
	}
}