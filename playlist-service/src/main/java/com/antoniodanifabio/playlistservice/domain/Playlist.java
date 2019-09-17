package com.antoniodanifabio.playlistservice.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "playlists")
public class Playlist {

    @Id
    private ObjectId id;
    private String name;
    private List<String> songIds = new ArrayList<>();

    public Playlist() {
        this.name = "Not Found.";
    }

    public Playlist(String name) {
        this.name = name;
    }

    public String getId() {
        return id.toHexString();
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSongIds() {
        return songIds;
    }

    public void setSongIds(List<String> songIds) {
        this.songIds = songIds;
    }
}
