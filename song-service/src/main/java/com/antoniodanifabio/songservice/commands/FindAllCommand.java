package com.antoniodanifabio.songservice.commands;

import java.util.List;
import com.antoniodanifabio.songservice.domain.Song;
import com.antoniodanifabio.songservice.repository.SongRepository;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

public class FindAllCommand extends HystrixCommand<List<Song>>{
	
	private SongRepository repository;
	
	public FindAllCommand(SongRepository repository) {
		super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("song"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(10000)));
		this.repository = repository;
	}

	@Override
	protected List<Song> run() throws Exception {
		return repository.findAll();
	}
	
	@Override
	protected List<Song> getFallback() {
		return null;
	}
	
}
