package com.antoniodanifabio.playlistservice.discovery;

import feign.Feign;
import feign.gson.GsonDecoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EurekaHeartbeat {

    @Value("${host.name}")
    private String hostName;

    @Value("${service.name}")
    private String serviceName;
    
    @Value("${eureka.url}")
    private String eurekaAddress;

    @Scheduled(fixedRate = 20000)
    public void heartBeat(){
    	
    	EurekaHttpClient eurekaHttpMethodsService = Feign
                .builder()
                .decoder(new GsonDecoder())
                .target(EurekaHttpClient.class, eurekaAddress);
    	
        eurekaHttpMethodsService.heartBeat(serviceName, hostName);
    }
}
