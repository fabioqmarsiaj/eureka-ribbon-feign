package com.antoniodanifabio.appservice.operation;

import com.antoniodanifabio.appservice.domain.Playlist;
import feign.Param;
import feign.RequestLine;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface PlaylistOperation {

    @RequestLine("GET /playlists")
    List<Playlist> getAllPlaylists();

    @RequestLine("GET /playlists/{playlistId}")
    Playlist searchById(@Param("playlistId") String playlistId);
}
