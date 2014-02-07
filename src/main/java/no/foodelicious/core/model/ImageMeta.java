package no.foodelicious.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImageMeta {

	public ImageMeta() {
	}

	public ImageMeta(String id, String filename) {
		super();
		this.id = id;
		this.filename = filename;
	}

	@JsonProperty
	private String id;

	@JsonProperty
	private String filename;
}
