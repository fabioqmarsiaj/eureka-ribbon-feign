package com.antoniodanifabio.songservice.commands;

import java.util.ArrayList;
import java.util.List;

import com.antoniodanifabio.songservice.domain.Song;
import com.antoniodanifabio.songservice.repository.SongRepository;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class FindAllCommand extends HystrixCommand<List<Song>> {
	
	private SongRepository repository;
	
	public FindAllCommand(SongRepository repository) {
		super(HystrixCommandGroupKey.Factory.asKey("FindAll"));
		this.repository = repository;
	}

	@Override
	protected List<Song> run() throws Exception {
		return repository.findAll();
	}
	
	@Override
	protected List<Song> getFallback() {
		return new ArrayList<Song>();
	}
	
}
