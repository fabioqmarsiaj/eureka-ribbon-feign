package com.antoniodanifabio.appservice.command.playlist;

import java.util.ArrayList;
import java.util.List;
import com.antoniodanifabio.appservice.discovery.PlaylistFeign;
import org.springframework.beans.factory.annotation.Autowired;
import com.antoniodanifabio.appservice.domain.Playlist;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class GetAllPlaylistsCommand extends HystrixCommand<List<Playlist>> {

    @Autowired
    private PlaylistFeign playlistFeign;

    public GetAllPlaylistsCommand(PlaylistFeign playlistFeign) {
        super(HystrixCommandGroupKey.Factory.asKey("GetAllPlaylists"));
        this.playlistFeign = playlistFeign;
    }

    @Override
    protected List<Playlist> run() throws Exception {
        return playlistFeign.getFeignBuilder().getAllPlaylists();
    }

    @Override
    protected List<Playlist> getFallback() {
        return new ArrayList<>();
    }
}
