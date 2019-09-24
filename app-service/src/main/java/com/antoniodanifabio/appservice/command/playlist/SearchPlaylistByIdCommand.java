package com.antoniodanifabio.appservice.command.playlist;

import org.springframework.beans.factory.annotation.Autowired;

import com.antoniodanifabio.appservice.domain.Playlist;
import com.antoniodanifabio.appservice.operation.PlaylistOperation;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class SearchPlaylistByIdCommand extends HystrixCommand<Playlist> {
	
	@Autowired
    private PlaylistOperation playlistOperation;

    private String playlistId;

    public SearchPlaylistByIdCommand(String playlistId) {
        super(HystrixCommandGroupKey.Factory.asKey("SearchPlaylistById"));
        this.playlistId = playlistId;
    }

    @Override
    protected Playlist run() throws Exception {
        return playlistOperation.searchById(playlistId);
    }

    @Override
    protected Playlist getFallback() {
        return new Playlist(null, "Default");
    }
}
