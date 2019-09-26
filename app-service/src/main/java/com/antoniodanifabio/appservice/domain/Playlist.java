package com.antoniodanifabio.appservice.domain;

import java.util.ArrayList;
import java.util.List;

public class Playlist {

    private String id;
    private String name;
    private List<String> songIds = new ArrayList<>();

    public Playlist(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getSongIds() {
        return songIds;
    }
}
