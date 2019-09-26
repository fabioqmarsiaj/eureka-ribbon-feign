package com.antoniodanifabio.songservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.antoniodanifabio.songservice.domain.Song;

public interface SongRepository extends MongoRepository<Song, String>{}
