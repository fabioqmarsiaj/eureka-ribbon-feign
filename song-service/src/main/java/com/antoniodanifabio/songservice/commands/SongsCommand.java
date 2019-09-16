package com.antoniodanifabio.songservice.commands;

import org.springframework.beans.factory.annotation.Autowired;

import com.antoniodanifabio.songservice.domain.Song;
import com.antoniodanifabio.songservice.repository.SongRepository;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

public class SongsCommand extends HystrixCommand<Song>{
	
	@Autowired
	private SongRepository repository;
	private String idSong;
	
	public SongsCommand(String idSong) {
		super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("song"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(10000)));
		this.idSong = idSong;
	}

	@Override
	protected Song run() throws Exception {
		repository.deleteById(idSong);
		return null;
	}
	
	@Override
	protected Song getFallback() {
		return new Song();
	}
	
}
