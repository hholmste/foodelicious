package no.foodelicious.core.configuration;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MongoConfiguration {

	public MongoConfiguration() {
	}

	public MongoConfiguration(String url, int port, String database) {
		this.url = url;
		this.port = port;
		this.database = database;
	}

	@NotNull
	@JsonProperty
	private String url;
	
	@Min(1)
	@Max(655351)
	@JsonProperty
	private int port;
	
	@NotNull
	@JsonProperty
	private String database;
	
	public String getUrl(){
		return url;
	}
	
	public int getPort(){
		return port;
	}
	
	public String getDatabase(){
	    return database;
	}
}