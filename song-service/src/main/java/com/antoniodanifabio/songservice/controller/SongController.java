package com.antoniodanifabio.songservice.controller;

import java.util.List;

import com.antoniodanifabio.songservice.domain.Song;
import com.antoniodanifabio.songservice.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/song")
public class SongController {
	
	@Autowired
	private SongRepository repository;
	
	@PostMapping(value = "/insert/{titleSong}")
	public void insertSong(
						   @PathVariable String titleSong) {
		Song song = new Song();
		song.setTitle(titleSong);
		repository.save(song);
	}
	
	@RequestMapping(value = "/all")
	public List<Song> getAllSongs() {
		return repository.findAll();
	}

	@PostMapping(value = "/delete/{titleSong}")
	public void deleteSong(
			@PathVariable String titleSong){
		
		repository.delete(repository.getSongByTitleEquals(titleSong));
	}

	private Song findSong(String titleSong){
		return repository.findByTitle(titleSong);
	}
	
}
