package com.antoniodanifabio.appservice.command.song;

import com.antoniodanifabio.appservice.discovery.SongFeign;
import com.antoniodanifabio.appservice.domain.Song;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.springframework.beans.factory.annotation.Autowired;

public class GetSongDetailCommand extends HystrixCommand<Song> {

    private String songId;
    @Autowired
    private SongFeign songFeign;

    public GetSongDetailCommand(String songId) {
        super(HystrixCommandGroupKey.Factory.asKey("GetSongDetail"));
        this.songId = songId;
    }

    @Override
    protected Song run() throws Exception {
        return songFeign.getFeignBuilder().searchById(songId);
    }

    @Override
    protected Song getFallback() {
        return new Song(null, "Default");
    }
}
