package com.antoniodanifabio.playlistservice.controller;

import com.antoniodanifabio.playlistservice.domain.Playlist;
import com.antoniodanifabio.playlistservice.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlaylistController{

    @Autowired
    private PlaylistService playlistService;

    @PostMapping("/playlists")
    public void insertPlaylist(@RequestBody String name) {
        playlistService.insertPlaylist(name);
    }

    @RequestMapping(value = "/playlists", method = RequestMethod.GET)
    @ResponseBody
    public List<Playlist> getPlaylists(){
        return playlistService.getPlaylists();
    }

    @PostMapping("/playlists/{playlistId}")
    public void insertSong(@PathVariable String playlistId, @RequestBody String songId){
        playlistService.insertSong(playlistId, songId);
    }

    @GetMapping("/playlists/{playlistId}")
    public Playlist findPlaylistById(@PathVariable String id){
        return playlistService.findPlaylist(id);
    }
}
