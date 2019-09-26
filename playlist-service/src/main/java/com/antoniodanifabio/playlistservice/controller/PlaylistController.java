package com.antoniodanifabio.playlistservice.controller;

import com.antoniodanifabio.playlistservice.commands.FindAllCommand;
import com.antoniodanifabio.playlistservice.commands.FindByIdCommand;
import com.antoniodanifabio.playlistservice.commands.SavePlaylistCommand;
import com.antoniodanifabio.playlistservice.commands.SaveSongCommand;
import com.antoniodanifabio.playlistservice.domain.Playlist;
import com.antoniodanifabio.playlistservice.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class PlaylistController{

    @Autowired
    private PlaylistRepository repository;

    @PostMapping("/playlists")
    public ResponseEntity<Playlist> insertPlaylist(@RequestBody Playlist newPlaylist) {     
        return ResponseEntity.status(HttpStatus.OK).body(new SavePlaylistCommand(repository, newPlaylist).execute());
    }

    @RequestMapping(value = "/playlists", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Playlist>> getPlaylists(){
        return ResponseEntity.status(HttpStatus.OK).body(new FindAllCommand(repository).execute());
    }

    @PostMapping("/playlists/{playlistId}")
    public ResponseEntity<Playlist> insertSong(@RequestBody String songId, @PathVariable String playlistId){
        return ResponseEntity.status(HttpStatus.OK).body(new SaveSongCommand(repository, songId, playlistId).execute());
    }

    @GetMapping("/playlists/{playlistId}")
    public ResponseEntity<Optional<Playlist>> findPlaylistById(@PathVariable String playlistId){
        return ResponseEntity.status(HttpStatus.OK).body(new FindByIdCommand(repository, playlistId).execute());
    }
}

