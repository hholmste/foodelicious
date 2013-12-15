package no.foodelicious.core.configuration;

import javax.validation.constraints.NotNull;

import com.bazaarvoice.dropwizard.assets.AssetsBundleConfiguration;
import com.bazaarvoice.dropwizard.assets.AssetsConfiguration;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.config.Configuration;

public class MainConfiguration extends Configuration implements AssetsBundleConfiguration{
	
	@NotNull
	@JsonProperty
	private MongoConfiguration mongoConfiguration = new MongoConfiguration();
	
	@NotNull
	@JsonProperty
	private final AssetsConfiguration assets = new AssetsConfiguration();
	
	public MongoConfiguration getMongoConfig(){
		return mongoConfiguration;
	}

	@Override
	public AssetsConfiguration getAssetsConfiguration() {
		return assets;
	}
}