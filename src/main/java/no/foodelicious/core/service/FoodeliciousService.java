package no.foodelicious.core.service;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import no.foodelicious.core.configuration.MainConfiguration;
import no.foodelicious.core.factory.RepositoryFactory;
import no.foodelicious.core.health.MongoHealth;
import no.foodelicious.core.resources.ImageResource;
import no.foodelicious.core.resources.RecipeResource;

import org.eclipse.jetty.server.session.SessionHandler;

import com.bazaarvoice.dropwizard.assets.ConfiguredAssetsBundle;
import com.sun.jersey.api.container.filter.LoggingFilter;
import com.sun.jersey.api.core.ResourceConfig;

public class FoodeliciousService extends Application<MainConfiguration> {

	public static void main(String[] args) throws Exception {
		new FoodeliciousService().run(args);
	}
	
	@Override
	public String getName(){
		return "foodelicious";
	}

	@Override
	public void initialize(Bootstrap<MainConfiguration> bootstrap) {
		bootstrap.addBundle(new ConfiguredAssetsBundle("/assets/", "/", "index.html"));
	}

	@Override
	public void run(MainConfiguration configuration, Environment environment)throws Exception {
		// resources goes here
		environment.jersey().register(new RecipeResource(new RepositoryFactory().create(configuration.getMongoConfig())));
		environment.jersey().register(new ImageResource(new RepositoryFactory().createGridFS( configuration.getMongoConfig() )));
		

		// health checks goes here
		environment.healthChecks().register("MongoDB", new MongoHealth(new RepositoryFactory().getDatatore(configuration.getMongoConfig()).getMongo()));
		
		environment.jersey().register(new SessionHandler());
	}
}