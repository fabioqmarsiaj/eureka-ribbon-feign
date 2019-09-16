package com.antoniodanifabio.appservice.controller;

import com.antoniodanifabio.appservice.operation.SongOperation;
import feign.Feign;
import feign.gson.GsonDecoder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    private SongOperation songOperation = Feign.builder()
            .decoder(new GsonDecoder())
            .target(SongOperation.class, "http://localhost:8090");

    @GetMapping()
    public ResponseEntity getSongs() {
        return ResponseEntity.ok(songOperation.getAllSongs());
    }

    @PostMapping
    public ResponseEntity insertNewSong(@RequestBody String jsonSong) {
        return ResponseEntity.ok(songOperation.insertSong(jsonSong));
    }
}
