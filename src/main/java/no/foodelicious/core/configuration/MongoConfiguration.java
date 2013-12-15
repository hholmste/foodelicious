package no.foodelicious.core.configuration;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;


public class MongoConfiguration {
	
	@NotNull
	@JsonProperty
	private String url;
	
	@Min(1)
	@Max(655351)
	@JsonProperty
	private int port;
	
	public String getUrl(){
		return url;
	}
	
	public int getPort(){
		return port;
	}
}