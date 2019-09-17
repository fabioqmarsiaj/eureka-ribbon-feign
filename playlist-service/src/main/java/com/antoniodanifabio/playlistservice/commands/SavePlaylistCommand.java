package com.antoniodanifabio.playlistservice.commands;

import com.antoniodanifabio.playlistservice.domain.Playlist;
import com.antoniodanifabio.playlistservice.repository.PlaylistRepository;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;


public class SavePlaylistCommand extends HystrixCommand<Playlist> {

    private PlaylistRepository repository;
    private Playlist newPlaylist;

    public SavePlaylistCommand(PlaylistRepository repository, Playlist newPlaylist) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("song"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(10000)));
        this.repository = repository;
        this.newPlaylist = newPlaylist;
    }

    @Override
    protected Playlist run() throws Exception {
        return repository.save(newPlaylist);
    }

    @Override
    protected Playlist getFallback() {
        return new Playlist();
    }
}
