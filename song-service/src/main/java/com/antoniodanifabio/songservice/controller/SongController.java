package com.antoniodanifabio.songservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.antoniodanifabio.songservice.commands.SaveSongCommand;
import com.antoniodanifabio.songservice.commands.SearchCommand;
import com.antoniodanifabio.songservice.commands.SongsCommand;
import com.antoniodanifabio.songservice.domain.Song;
import com.antoniodanifabio.songservice.repository.SongRepository;
import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;

@RestController
@RequestMapping("/songs")
public class SongController {
	
//	@Autowired
//	private ServletRegistrationBean<HystrixMetricsStreamServlet> servletRegistrationBean;
	
	@Autowired
	private SongRepository repository;
	
	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<List<Song>> getAllSongs() {
		return ResponseEntity.status(HttpStatus.OK).body(new SongsCommand(repository).execute());
	}

	@PostMapping
	public ResponseEntity<Song> insertSong(@RequestBody Song newSong) {
		return ResponseEntity.status(HttpStatus.CREATED).body(new SaveSongCommand(repository, newSong).execute());
	}

	@GetMapping(value = "/{songId}")
	public ResponseEntity<Song> searchSong(@PathVariable String songId) {
		return ResponseEntity.status(HttpStatus.OK).body(new SearchCommand(repository, songId).execute());
	}
	
//	@RequestMapping(value = "/hystrix.stream", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
//	public ResponseEntity<ServletRegistrationBean<HystrixMetricsStreamServlet>> getHystrixMetrics() {
//		return new ResponseEntity<ServletRegistrationBean<HystrixMetricsStreamServlet>>(servletRegistrationBean, HttpStatus.OK);
//	}
	
}
