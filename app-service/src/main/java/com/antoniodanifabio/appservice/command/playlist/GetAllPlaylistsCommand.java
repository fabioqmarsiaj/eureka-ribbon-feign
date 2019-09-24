package com.antoniodanifabio.appservice.command.playlist;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.antoniodanifabio.appservice.domain.Playlist;
import com.antoniodanifabio.appservice.operation.PlaylistOperation;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class GetAllPlaylistsCommand extends HystrixCommand<List<Playlist>> {

	@Autowired
    private PlaylistOperation playlistOperation;

    public GetAllPlaylistsCommand() {
        super(HystrixCommandGroupKey.Factory.asKey("GetAllPlaylists"));
    }

    @Override
    protected List<Playlist> run() throws Exception {
        return playlistOperation.getAllPlaylists();
    }

    @Override
    protected List<Playlist> getFallback() {
        return new ArrayList<>();
    }
}
