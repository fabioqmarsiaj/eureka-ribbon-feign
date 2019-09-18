package com.antoniodanifabio.appservice.command.song;

import com.antoniodanifabio.appservice.domain.Song;
import com.antoniodanifabio.appservice.operation.SongOperation;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import feign.Feign;
import feign.gson.GsonDecoder;

public class GetSongDetailCommand extends HystrixCommand<Song> {

    private SongOperation songOperation = Feign.builder()
            .decoder(new GsonDecoder())
            .target(SongOperation.class, "http://localhost:8091");

    private String songId;

    public GetSongDetailCommand(String songId) {
        super(HystrixCommandGroupKey.Factory.asKey("GetSongDetail"));
        this.songId = songId;
    }

    @Override
    protected Song run() throws Exception {
        return songOperation.searchById(songId);
    }

    @Override
    protected Song getFallback() {
        return new Song(null, "Default");
    }
}
