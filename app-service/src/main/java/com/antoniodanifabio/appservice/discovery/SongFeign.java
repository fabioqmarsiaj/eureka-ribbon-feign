package com.antoniodanifabio.appservice.discovery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.antoniodanifabio.appservice.operation.SongOperation;

import feign.Feign;
import feign.gson.GsonDecoder;

@Component
public class SongFeign {
	
	@Autowired
	private String baseLoadBalancer;

	public SongOperation getFeignBuilder() {
		return Feign.builder()
	            .decoder(new GsonDecoder())
	            .target(SongOperation.class, baseLoadBalancer);
	}
	
}
