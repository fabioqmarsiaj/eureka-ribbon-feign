package com.antoniodanifabio.appservice.discovery;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import feign.Feign;
import feign.gson.GsonDecoder;

@Component
public class EurekaFeign {
	
	@Value("${eureka.url}")
    private String eurekaUrl;
	
	public EurekaHttpMethods getFeignBuilder() {
		return Feign.builder()
	            .decoder(new GsonDecoder())
	            .target(EurekaHttpMethods.class, eurekaUrl);
	}
	
}
