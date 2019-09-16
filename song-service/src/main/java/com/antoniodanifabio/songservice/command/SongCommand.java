package com.antoniodanifabio.songservice.command;

import com.antoniodanifabio.songservice.domain.Song;
import com.antoniodanifabio.songservice.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongCommand {

    @Autowired
    private SongRepository repository;

    public Song insertNewSong(Song newSong) {
        return repository.save(newSong);
    }

    public List<Song> getAllSongs() {
        return repository.findAll();
    }

    public Song searchSongById(String songId) {
        return repository.findById(songId).get();
    }
}
