package com.antoniodanifabio.songservice.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "song")
public class Song {

	private String title;
	private String meMapeie;
	
	public Song() {}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
