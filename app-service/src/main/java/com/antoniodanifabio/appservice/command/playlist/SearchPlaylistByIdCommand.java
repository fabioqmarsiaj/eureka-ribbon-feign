package com.antoniodanifabio.appservice.command.playlist;

import com.antoniodanifabio.appservice.discovery.PlaylistFeign;
import org.springframework.beans.factory.annotation.Autowired;
import com.antoniodanifabio.appservice.domain.Playlist;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class SearchPlaylistByIdCommand extends HystrixCommand<Playlist> {

    @Autowired
    private PlaylistFeign playlistFeign;

    private String playlistId;

    public SearchPlaylistByIdCommand(String playlistId, PlaylistFeign playlistFeign) {
        super(HystrixCommandGroupKey.Factory.asKey("SearchPlaylistById"));
        this.playlistId = playlistId;
        this.playlistFeign = playlistFeign;
    }

    @Override
    protected Playlist run() throws Exception {
        return playlistFeign.getFeignBuilder().searchById(playlistId);
    }

    @Override
    protected Playlist getFallback() {
        return new Playlist(null, "Default");
    }
}
