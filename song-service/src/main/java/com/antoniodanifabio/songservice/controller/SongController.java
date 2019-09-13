package com.antoniodanifabio.songservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.antoniodanifabio.songservice.domain.Song;
import com.antoniodanifabio.songservice.repository.SongRepository;

@RestController
@RequestMapping("/songs")
public class SongController {
	
	@Autowired
	private SongRepository repository;
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public void insertSong(@RequestBody Song newSong) {
		repository.save(newSong);
	}
	
	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	public List<Song> getAllSongs() {
		return repository.findAll();
	}

	@PostMapping(value = "/{idSong}")
	public void deleteSong(@PathVariable String idSong){
		repository.deleteById(idSong);
	}
	
	@GetMapping(value = "/{idSong}")
	public Song searchSong(@PathVariable String idSong) {
		return repository.findById(idSong).get();
	}
	
}
