package com.antoniodanifabio.playlistservice.discovery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EurekaHeartbeat {

    @Value("${host.name}")
    private String hostName;

    @Value("${service.name}")
    private String serviceName;
    
    @Autowired
    private EurekaFeign eurekaFeign;

    @Scheduled(fixedRate = 20000)
    public void heartBeat(){
    	eurekaFeign.getFeignBuilder().heartBeat(serviceName, hostName);
    }
}
