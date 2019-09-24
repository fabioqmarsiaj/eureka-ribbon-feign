package com.antoniodanifabio.playlistservice.commands;

import com.antoniodanifabio.playlistservice.domain.Playlist;
import com.antoniodanifabio.playlistservice.repository.PlaylistRepository;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import java.util.Optional;

public class FindByIdCommand extends HystrixCommand<Optional<Playlist>> {

    private PlaylistRepository repository;
    private String playlistId;

    public FindByIdCommand(PlaylistRepository repository, String playlistId) {
        super(HystrixCommandGroupKey.Factory.asKey("FindById"));
        this.repository = repository;
        this.playlistId = playlistId;
    }

    @Override
    protected Optional<Playlist> run() throws Exception {
        return repository.findById(playlistId);
    }
}
