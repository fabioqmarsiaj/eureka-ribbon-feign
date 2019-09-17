package com.antoniodanifabio.appservice.controller;

import com.antoniodanifabio.appservice.operation.PlaylistOperation;
import feign.Feign;
import feign.gson.GsonDecoder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/playlists")
public class PlaylistController {

    private PlaylistOperation playlistOperation = Feign.builder()
            .decoder(new GsonDecoder())
            .target(PlaylistOperation.class, "http://localhost:8081");

    @GetMapping
    public ResponseEntity getPlaylists() {
        return ResponseEntity.ok(playlistOperation.getAllPlaylists());
    }

    @PostMapping
    public ResponseEntity insertNewPlaylist(@RequestBody String jsonPlaylist) {
        return ResponseEntity.ok(playlistOperation.insertPlaylist(jsonPlaylist));
    }

    @GetMapping("/{id}")
    public ResponseEntity searchPlaylistById(@PathVariable String id) {
        return ResponseEntity.ok(playlistOperation.searchById(id));
    }

    @PostMapping("/{playlistId}")
    public ResponseEntity insertNewSongOnPlaylist(@RequestBody String jsonSong, @PathVariable String playlistId) {
        return ResponseEntity.ok(playlistOperation.insertSongOnPlaylist(jsonSong, playlistId));
    }
}
