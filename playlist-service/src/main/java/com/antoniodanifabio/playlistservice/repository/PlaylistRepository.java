package com.antoniodanifabio.playlistservice.repository;


import com.antoniodanifabio.playlistservice.domain.Playlist;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlaylistRepository extends MongoRepository<Playlist, String> {

}
