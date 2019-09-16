package com.antoniodanifabio.appservice.operation;

import com.antoniodanifabio.appservice.domain.Song;
import feign.RequestLine;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SongOperation {

    @RequestLine("GET /songs")
    List<Song> getAllSongs();

}
