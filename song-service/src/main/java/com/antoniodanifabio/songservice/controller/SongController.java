package com.antoniodanifabio.songservice.controller;

import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.antoniodanifabio.songservice.commands.SaveCommand;
import com.antoniodanifabio.songservice.commands.SearchCommand;
import com.antoniodanifabio.songservice.commands.FindAllCommand;
import com.antoniodanifabio.songservice.domain.Song;
import com.antoniodanifabio.songservice.repository.SongRepository;

@RestController
@RequestMapping
public class SongController {
	
	@Autowired
	private SongRepository repository;
	
	@GetMapping("/status")
	public Response getStatus(){
		return Response.ok().build();
	}
	
	@GetMapping("/songs")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<List<Song>> getAllSongs() {
		return ResponseEntity.status(HttpStatus.OK).body(new FindAllCommand(repository).execute());
	}

	@PostMapping("/songs")
	public ResponseEntity<Song> insertSong(@RequestBody Song newSong) {
		return ResponseEntity.status(HttpStatus.CREATED).body(new SaveCommand(repository, newSong).execute());
	}

	@GetMapping(value = "/songs/{songId}")
	public ResponseEntity<Song> searchSong(@PathVariable String songId) {
		return ResponseEntity.status(HttpStatus.OK).body(new SearchCommand(repository, songId).execute());
	}
	
}
