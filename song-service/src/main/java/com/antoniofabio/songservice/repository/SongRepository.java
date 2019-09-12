package com.antoniofabio.songservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.cdi.MongoRepositoryBean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.antoniofabio.songservice.domain.Song;

public interface SongRepository extends MongoRepository<Song, Integer>{

//	@Query("{ 'firstname' : ?0 }")
//	public Song getRandomSong();
}
