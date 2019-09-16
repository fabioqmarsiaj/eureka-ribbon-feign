package com.antoniodanifabio.songservice.controller;

import com.antoniodanifabio.songservice.command.SongCommand;
import com.antoniodanifabio.songservice.domain.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/songs")
public class SongController {
	
	@Autowired
	private SongCommand command;
	
	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<List<Song>> getAllSongs() {
		return ResponseEntity.status(HttpStatus.OK).body(command.getAllSongs());
	}

	@PostMapping
	public ResponseEntity<Song> insertSong(@RequestBody Song newSong) {
		Song insertedSong = command.insertNewSong(newSong);
		return ResponseEntity.status(HttpStatus.CREATED).body(insertedSong);
	}

	@GetMapping(value = "/{songId}")
	public ResponseEntity<Song> searchSong(@PathVariable String songId) {
		return ResponseEntity.status(HttpStatus.OK).body(command.searchSongById(songId));
	}
}
