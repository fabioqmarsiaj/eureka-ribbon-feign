package com.antoniodanifabio.songservice.controller;

import java.util.List;

import com.antoniodanifabio.songservice.domain.Song;
import com.antoniodanifabio.songservice.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/song")
public class SongController {
	
	@Autowired
	private SongRepository repository;
	
	@RequestMapping(value = "/insert/{idSong}/{titleSong}")
	public void insertSong(@PathVariable Integer idSong,
						   @PathVariable String titleSong) {
		Song song = new Song();
		song.setId(idSong);
		song.setTitle(titleSong);
		repository.save(song);
	}
	
	@RequestMapping(value = "/all")
	public List<Song> getAllSongs() {
		return repository.findAll();
	}
	
}
