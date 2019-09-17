package com.antoniodanifabio.appservice.command.playlist;

import com.antoniodanifabio.appservice.domain.Playlist;
import com.antoniodanifabio.appservice.operation.PlaylistOperation;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import feign.Feign;
import feign.gson.GsonDecoder;

public class SearchPlaylistByIdCommand extends HystrixCommand<Playlist> {

    private PlaylistOperation playlistOperation = Feign.builder()
            .decoder(new GsonDecoder())
            .target(PlaylistOperation.class, "http://localhost:8081");

    private String playlistId;

    public SearchPlaylistByIdCommand(String playlistId) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("searchPlaylist"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(10000)));
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
