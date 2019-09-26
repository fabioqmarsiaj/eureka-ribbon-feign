package com.antoniodanifabio.songservice.discovery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EurekaHeartbeat {

    @Value("${server.port}")
    private String serverPort;
    @Value("${ip.address}")
    private String ipAddress;
    @Value("${host.name}")
    private String hostName;
    @Value("${service.name}")
    private String serviceName;
    @Autowired
    private EurekaFeign eurekaFeign;

    @Scheduled(fixedRate = 20000)
    public void heartBeat(){
    	eurekaFeign.getFeignBuilder().heartBeat(serviceName, buildInstanceID(ipAddress, serverPort, serviceName));
    }
    
    private String buildInstanceID(String ip, String port, String appName) {
        return String.format("%s_%s_%s", appName, ip, port);
    }
}
