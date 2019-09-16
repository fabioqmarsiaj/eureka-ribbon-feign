package com.antoniodanifabio.songservice.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "songs")
public class Song {

	@Id
	private ObjectId id;
	
	private String title;
	
	public Song() {}
	
	public Song(ObjectId id, String title) {
		this.id = id;
		this.title = title;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
