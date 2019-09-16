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
import com.antoniodanifabio.songservice.domain.Song;
import com.antoniodanifabio.songservice.repository.SongRepository;
import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;

@RestController
@RequestMapping("/songs")
public class SongController {
	
	@Autowired
	private ServletRegistrationBean<HystrixMetricsStreamServlet> servletRegistrationBean;
	
	@Autowired
	private SongRepository repository;
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public void insertSong(@RequestBody Song newSong) {
		new SaveSongCommand(newSong).execute();
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
	
	@RequestMapping(value = "/hystrix.stream", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
	public ResponseEntity<ServletRegistrationBean<HystrixMetricsStreamServlet>> getHystrixMetrics() {
		return new ResponseEntity<ServletRegistrationBean<HystrixMetricsStreamServlet>>(servletRegistrationBean, HttpStatus.OK);
	}
	
}
