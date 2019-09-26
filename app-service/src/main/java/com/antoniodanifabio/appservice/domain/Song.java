package com.antoniodanifabio.appservice.domain;

public class Song {

    private String id;
    private String title;

    public Song() {
    }

    public Song(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
