package com.antoniodanifabio.appservice.command.song;

import org.springframework.beans.factory.annotation.Autowired;

import com.antoniodanifabio.appservice.discovery.SongFeign;
import com.antoniodanifabio.appservice.domain.Song;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class GetSongDetailCommand extends HystrixCommand<Song> {

	@Autowired
	private SongFeign songFeign;
    private String songId;

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
