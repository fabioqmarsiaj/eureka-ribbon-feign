package com.antoniodanifabio.songservice.repository;

import com.antoniodanifabio.songservice.domain.Song;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.cdi.MongoRepositoryBean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

public interface SongRepository extends MongoRepository<Song, String>{

    Song findByTitle(String titleSong);
    Song getSongByTitleEquals(String titleSong);

}
