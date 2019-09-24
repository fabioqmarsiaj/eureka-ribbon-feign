package com.antoniodanifabio.playlistservice.commands;

import java.util.Optional;

import com.antoniodanifabio.playlistservice.domain.Playlist;
import com.antoniodanifabio.playlistservice.repository.PlaylistRepository;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

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
        Optional<Playlist> playlist = new FindByIdCommand(repository, playlistId).execute();  
        playlist.get().getSongIds().add(songId);
        return repository.save(playlist.get());
    }

    @Override
    protected Playlist getFallback() {
        return new Playlist();
    }
}
