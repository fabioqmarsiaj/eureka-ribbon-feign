package com.antoniodanifabio.appservice.command.playlist;

import com.antoniodanifabio.appservice.domain.Playlist;
import com.antoniodanifabio.appservice.operation.PlaylistOperation;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import feign.Feign;
import feign.gson.GsonDecoder;

import java.util.ArrayList;
import java.util.List;

public class GetAllPlaylistsCommand extends HystrixCommand<List<Playlist>> {

    private PlaylistOperation playlistOperation = Feign.builder()
            .decoder(new GsonDecoder())
            .target(PlaylistOperation.class, "http://localhost:8081");

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
