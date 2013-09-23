package no.foodelicious.service;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

public class RecipeSearchService extends Service<RecipeConfiguration>{
    
    public static void main(String[] args) throws Exception {
        new RecipeSearchService().run(args);
    }

    @Override
    public void initialize(Bootstrap<RecipeConfiguration> bootstrap) {
        bootstrap.setName("foodelicious");
    }

    @Override
    public void run(RecipeConfiguration configuration, Environment environment) throws Exception {
        environment.addResource(new RecipeSearchResource());
        environment.addResource(new RecipeListResource());
        environment.addResource(new RecipeCreateResource());
    }
}
