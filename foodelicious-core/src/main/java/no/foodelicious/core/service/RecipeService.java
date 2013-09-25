package no.foodelicious.core.service;

import no.foodelicious.core.configuration.RecipeConfiguration;
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
    public void run(RecipeConfiguration configuration, Environment environment) throws Exception {
        environment.addResource(new RecipeResource());
    }
}
