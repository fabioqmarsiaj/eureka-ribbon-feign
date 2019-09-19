package com.antoniodanifabio.songservice.commands;

import com.antoniodanifabio.songservice.domain.Song;
import com.antoniodanifabio.songservice.repository.SongRepository;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class SearchCommand extends HystrixCommand<Song>{
	
	private SongRepository repository;
	private String songId;
	
	public SearchCommand(SongRepository repository, String songId) {
		super(HystrixCommandGroupKey.Factory.asKey("Search"));
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
