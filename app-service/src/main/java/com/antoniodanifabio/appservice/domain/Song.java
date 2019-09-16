package com.antoniodanifabio.appservice.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Song {

    @Id
    private ObjectId id;
    private String title;

    public Song(ObjectId id, String title) {
        this.id = id;
        this.title = title;
    }

    public ObjectId getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
