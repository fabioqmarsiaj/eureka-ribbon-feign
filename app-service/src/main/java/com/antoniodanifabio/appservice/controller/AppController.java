package com.antoniodanifabio.appservice.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.antoniodanifabio.appservice.command.playlist.GetAllPlaylistsCommand;
import com.antoniodanifabio.appservice.command.playlist.SearchPlaylistByIdCommand;
import com.antoniodanifabio.appservice.command.song.GetSongDetailCommand;
import com.antoniodanifabio.appservice.discovery.PlaylistFeign;
import com.antoniodanifabio.appservice.discovery.SongFeign;
import com.antoniodanifabio.appservice.domain.Playlist;
import com.antoniodanifabio.appservice.domain.Song;

@RestController
@RequestMapping
public class AppController {
	
	@Autowired
	private PlaylistFeign playlistFeign;
	@Autowired
	private SongFeign songFeign;
	
	@GetMapping("/status")
	public Response getStatus(){
		return Response.ok().build();
	}

    @GetMapping("/app")
    public ResponseEntity<List<Playlist>> getAllPlaylists() {
        return ResponseEntity.ok(new GetAllPlaylistsCommand(playlistFeign).execute());
    }
    
    @GetMapping("/app/{playlistId}")
    public ResponseEntity<List<Song>> getSongsFromPlaylist(@PathVariable String playlistId) {
        List<String> songsIds = new SearchPlaylistByIdCommand(playlistId, playlistFeign).execute().getSongIds();

        List<Song> songsDetails = songsIds
                .stream()
                .map(songId -> new GetSongDetailCommand(songId, songFeign).execute())
                .collect(Collectors.toList());
    	return ResponseEntity.ok(songsDetails);
    }
}
