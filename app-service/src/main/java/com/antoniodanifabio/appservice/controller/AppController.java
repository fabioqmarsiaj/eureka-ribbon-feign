package com.antoniodanifabio.appservice.controller;


import com.antoniodanifabio.appservice.command.playlist.GetAllPlaylistsCommand;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AppController {

    @GetMapping
    public ResponseEntity getAllPlaylists() {
        return ResponseEntity.ok(new GetAllPlaylistsCommand().execute());
    }
}
