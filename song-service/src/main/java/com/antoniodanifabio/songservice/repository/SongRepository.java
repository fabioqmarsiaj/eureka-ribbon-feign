package com.antoniodanifabio.songservice.repository;

import com.antoniodanifabio.songservice.domain.Song;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SongRepository extends MongoRepository<Song, String>{
    Optional<Song> findById(String titleSong);
}
