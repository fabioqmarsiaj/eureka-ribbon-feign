package com.antoniodanifabio.playlistservice.commands;

import com.antoniodanifabio.playlistservice.domain.Playlist;
import com.antoniodanifabio.playlistservice.repository.PlaylistRepository;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

import java.util.List;

public class FindAllCommand extends HystrixCommand<List<Playlist>> {
    private PlaylistRepository repository;

    public FindAllCommand(PlaylistRepository repository) {
        super(HystrixCommandGroupKey.Factory.asKey("FindAll"));
        this.repository = repository;
    }

    @Override
    protected List<Playlist> run() throws Exception {
        return repository.findAll();
    }

    @Override
    protected List<Playlist> getFallback() {
        return null;
    }
}
