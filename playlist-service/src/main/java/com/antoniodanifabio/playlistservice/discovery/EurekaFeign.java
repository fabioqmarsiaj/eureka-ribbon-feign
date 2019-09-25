package com.antoniodanifabio.playlistservice.discovery;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.antoniodanifabio.playlistservice.discovery.EurekaHttpClient;
import feign.Feign;
import feign.gson.GsonDecoder;

@Component
public class EurekaFeign {
	
	@Value("${eureka.url}")
    private String eurekaUrl;
	
	public EurekaHttpClient getFeignBuilder() {
		return Feign.builder()
	            .decoder(new GsonDecoder())
	            .target(EurekaHttpClient.class, eurekaUrl);
	}

}
