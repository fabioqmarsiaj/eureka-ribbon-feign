package com.antoniodanifabio.songservice.commands;

import com.antoniodanifabio.songservice.domain.Song;
import com.antoniodanifabio.songservice.repository.SongRepository;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

public class SaveCommand extends HystrixCommand<Song>{

	private SongRepository repository;
	private Song newSong;
	
	public SaveCommand(SongRepository repository, Song newSong) {
		super(HystrixCommandGroupKey.Factory.asKey("Save"));
		this.newSong = newSong;
		this.repository = repository;

	}

	@Override
	protected Song run() throws Exception {
		return repository.save(newSong);
	}
	
	@Override
	protected Song getFallback() {
		return new Song();
	}
	
}
