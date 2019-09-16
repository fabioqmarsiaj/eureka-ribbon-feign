package com.antoniodanifabio.songservice.commands;

import org.springframework.beans.factory.annotation.Autowired;

import com.antoniodanifabio.songservice.domain.Song;
import com.antoniodanifabio.songservice.repository.SongRepository;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

public class DeleteSongCommand extends HystrixCommand<Song>{
	
	@Autowired
	private SongRepository repository;
	private Song newSong;
	
	public DeleteSongCommand(Song newSong) {
		super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("song"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(10000)));
		this.newSong = newSong;
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
