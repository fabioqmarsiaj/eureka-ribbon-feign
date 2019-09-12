package com.antoniodanifabio.songservice.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "song")
public class Song {
	
	@Id
	private Integer id;
	private String title;
	
	public Song() {}
	
	public Integer getId() { return id; }
	
	public void setId(Integer id) { this.id = id; }

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
