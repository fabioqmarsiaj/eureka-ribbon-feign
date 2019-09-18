package com.antoniodanifabio.playlistservice.commands;

import com.antoniodanifabio.playlistservice.domain.Playlist;
import com.antoniodanifabio.playlistservice.repository.PlaylistRepository;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

public class SaveSongCommand extends HystrixCommand<Playlist> {

    private PlaylistRepository repository;
    private String songId;
    private String playlistId;

    public SaveSongCommand(PlaylistRepository repository, String songId, String playlistId) {
        super(HystrixCommandGroupKey.Factory.asKey("SaveSong"));
        this.repository = repository;
        this.songId = songId;
        this.playlistId = playlistId;
    }

    @Override
    protected Playlist run() throws Exception {
        Playlist playlist = new FindByIdCommand(repository, playlistId).execute();
        playlist.getSongIds().add(songId);
        return repository.save(playlist);
    }

    @Override
    protected Playlist getFallback() {
        return new Playlist();
    }
}
