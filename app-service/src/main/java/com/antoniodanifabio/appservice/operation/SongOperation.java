package com.antoniodanifabio.appservice.operation;

import com.antoniodanifabio.appservice.domain.Song;
import feign.Param;
import feign.RequestLine;

public interface SongOperation {

    @RequestLine("GET /songs/{songId}")
    Song searchById(@Param("songId") String songId);
}
