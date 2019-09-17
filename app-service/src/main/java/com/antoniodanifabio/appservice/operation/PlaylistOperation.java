package com.antoniodanifabio.appservice.operation;

import com.antoniodanifabio.appservice.domain.Playlist;
import feign.Body;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public interface PlaylistOperation {

    @RequestLine("GET /playlists")
    List<Playlist> getAllPlaylists();

    @RequestLine("POST /playlists")
    @Headers("Content-Type: application/json")
    @Body("{jsonPlaylist}")
    Playlist insertPlaylist(@Param("jsonPlaylist") String jsonPlaylist);

    @RequestLine("GET /playlists/{playlistId}")
    Playlist searchById(@Param("playlistId") String playlistId);

    @RequestLine("POST /playlists/{playlistId}")
    @Headers("Content-Type: application/json")
    @Body("{jsonSong}")
    Playlist insertSongOnPlaylist(@RequestBody String jsonSong, @Param("playlistId") String playlistId);
}
