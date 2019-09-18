package com.antoniodanifabio.appservice.controller;


import com.antoniodanifabio.appservice.command.playlist.GetAllPlaylistsCommand;
import com.antoniodanifabio.appservice.command.playlist.SearchPlaylistByIdCommand;
import com.antoniodanifabio.appservice.command.song.GetSongDetailCommand;
import com.antoniodanifabio.appservice.domain.Song;
import com.netflix.ribbon.Ribbon;
import com.netflix.ribbon.http.HttpRequestTemplate;
import io.netty.buffer.ByteBuf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rx.Observable;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping
public class AppController {

    @GetMapping
    public ResponseEntity getAllPlaylists() {
        return ResponseEntity.ok(new GetAllPlaylistsCommand().execute());
    }
    
    @GetMapping("/{playlistId}")
    public ResponseEntity getSongsFromPlaylist(@PathVariable String playlistId) {
        List<String> songsIds = new SearchPlaylistByIdCommand(playlistId).execute().getSongIds();

        List<Song> songsDetails = songsIds
                .stream()
                .map(songId -> new GetSongDetailCommand(songId).execute())
                .collect(Collectors.toList());
    	return ResponseEntity.ok(songsDetails);
    }
}
