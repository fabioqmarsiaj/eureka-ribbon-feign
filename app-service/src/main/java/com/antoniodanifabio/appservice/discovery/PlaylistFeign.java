package com.antoniodanifabio.appservice.discovery;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.antoniodanifabio.appservice.operation.PlaylistOperation;

import feign.Feign;
import feign.gson.GsonDecoder;

@Component
public class PlaylistFeign {
	
	@Value("${playlist.url}")
	private String playlistUrl;
	
	public PlaylistOperation getFeignBuilder() {
		return Feign.builder()
	            .decoder(new GsonDecoder())
	            .target(PlaylistOperation.class, playlistUrl);
	}
	
}
