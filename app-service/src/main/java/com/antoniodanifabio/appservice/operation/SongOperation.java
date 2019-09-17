package com.antoniodanifabio.appservice.operation;

import com.antoniodanifabio.appservice.domain.Song;
import feign.Body;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface SongOperation {

    @RequestLine("GET /songs")
    List<Song> getAllSongs();

    @RequestLine("POST /songs")
    @Headers("Content-Type: application/json")
    @Body("{jsonSong}")
    Song insertSong(@Param("jsonSong") String jsonSong);

    @RequestLine("GET /songs/{songId}")
    Song searchById(@Param("songId") String songId);
}
