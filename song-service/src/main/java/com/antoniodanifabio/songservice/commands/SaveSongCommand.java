package com.antoniodanifabio.songservice.commands;

import com.antoniodanifabio.songservice.domain.Song;
import com.antoniodanifabio.songservice.repository.SongRepository;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

public class SaveSongCommand extends HystrixCommand<Song>{

	private SongRepository repository;
	private Song newSong;
	
	public SaveSongCommand(SongRepository repository, Song newSong) {
		super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("song"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(10000)));
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
