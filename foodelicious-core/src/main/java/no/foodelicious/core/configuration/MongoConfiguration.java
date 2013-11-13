package no.foodelicious.core.configuration;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;


public class MongoConfiguration {
	
	@NotNull
	@JsonProperty
	private String host = "localhost";
	
	@Min(1)
	@Max(655351)
	@JsonProperty
	private int port = 27017;
	
	public String getHost(){
		return host;
	}
	
	public int getPort(){
		return port;
	}
}