package com.antoniodanifabio.songservice.commands;

import com.antoniodanifabio.songservice.domain.Song;
import com.antoniodanifabio.songservice.repository.SongRepository;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

public class SearchCommand extends HystrixCommand<Song>{
	
	private SongRepository repository;
	private String songId;
	
	public SearchCommand(SongRepository repository, String songId) {
		super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("song"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(10000)));
		this.songId = songId;
		this.repository = repository;
	}

	@Override
	protected Song run() throws Exception {
		return repository.findById(songId).get();
	}
	
	@Override
	protected Song getFallback() {
		return new Song();
	}
	
}
