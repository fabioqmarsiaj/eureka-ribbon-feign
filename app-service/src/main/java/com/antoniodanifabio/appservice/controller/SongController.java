package com.antoniodanifabio.appservice.controller;

import com.antoniodanifabio.appservice.operation.SongOperation;
import feign.Feign;
import feign.gson.GsonDecoder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/songs")
public class SongController {

    private SongOperation songOperation = Feign.builder()
            .decoder(new GsonDecoder())
            .target(SongOperation.class, "http://localhost:8090");

    @GetMapping
    public ResponseEntity getSongs() {
        return ResponseEntity.ok(songOperation.getAllSongs());
    }

    @PostMapping
    public ResponseEntity insertNewSong(@RequestBody String jsonSong) {
        return ResponseEntity.ok(songOperation.insertSong(jsonSong));
    }

    @GetMapping("/{id}")
    public ResponseEntity searchSongById(@PathVariable String id) {
        return ResponseEntity.ok(songOperation.searchById(id));
    }
}
