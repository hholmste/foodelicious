package no.foodelicious.core.service;

import no.foodelicious.core.configuration.MainConfiguration;
import no.foodelicious.core.factory.RepositoryFactory;
import no.foodelicious.core.health.MongoHealth;
import no.foodelicious.core.resources.ImageResource;
import no.foodelicious.core.resources.RecipeResource;

import org.eclipse.jetty.server.session.SessionHandler;

import com.bazaarvoice.dropwizard.assets.ConfiguredAssetsBundle;
import com.sun.jersey.api.container.filter.LoggingFilter;
import com.sun.jersey.api.core.ResourceConfig;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

public class FoodeliciousService extends Service<MainConfiguration> {

	public static void main(String[] args) throws Exception {
		new FoodeliciousService().run(args);
	}

	@Override
	public void initialize(Bootstrap<MainConfiguration> bootstrap) {
		bootstrap.setName("foodelicious");
		bootstrap.addBundle(new ConfiguredAssetsBundle("/assets/", "/", "index.html"));
	}

	@Override
	public void run(MainConfiguration configuration, Environment environment)throws Exception {
		// resources goes here
		environment.addResource(new RecipeResource(new RepositoryFactory().create(configuration.getMongoConfig())));
		environment.addResource(new ImageResource(new RepositoryFactory().createGridFS( configuration.getMongoConfig() )));
		
		//configure request/response logging
		environment.setJerseyProperty(ResourceConfig.PROPERTY_CONTAINER_REQUEST_FILTERS, LoggingFilter.class);
		environment.setJerseyProperty(ResourceConfig.PROPERTY_CONTAINER_RESPONSE_FILTERS, LoggingFilter.class);

		// health checks goes here
		environment.addHealthCheck(new MongoHealth(new RepositoryFactory().getDatatore(configuration.getMongoConfig()).getMongo()));
		
		environment.setSessionHandler(new SessionHandler());
	}
}