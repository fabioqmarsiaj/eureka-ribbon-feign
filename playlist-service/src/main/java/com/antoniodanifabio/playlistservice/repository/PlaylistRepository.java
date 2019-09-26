package com.antoniodanifabio.playlistservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.antoniodanifabio.playlistservice.domain.Playlist;

public interface PlaylistRepository extends MongoRepository<Playlist, String> {}
