package no.foodelicious.core.configuration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.config.Configuration;

public class RecipeConfiguration extends Configuration {
	
	@Valid
	@NotNull
	@JsonProperty
	private MongoConfiguration mongoConfiguration = new MongoConfiguration();
	
	public MongoConfiguration getMongoConfig(){
		return mongoConfiguration;
	}
}