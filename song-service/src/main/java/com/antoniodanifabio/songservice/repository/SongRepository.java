package com.antoniodanifabio.songservice.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.antoniodanifabio.songservice.domain.Song;

public interface SongRepository extends MongoRepository<Song, String>{
    Optional<Song> findById(String titleSong);
}
