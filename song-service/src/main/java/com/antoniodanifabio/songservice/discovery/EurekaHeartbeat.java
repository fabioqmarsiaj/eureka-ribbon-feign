package com.antoniodanifabio.songservice.discovery;

import feign.Feign;
import feign.gson.GsonDecoder;
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
    private EurekaOperations eurekaOperations;

    private EurekaHttpMethods eurekaHttpMethodsService = Feign
            .builder()
            .decoder(new GsonDecoder())
            .target(EurekaHttpMethods.class, "http://localhost:8080/eureka/v2/apps");

    @Scheduled(fixedRate = 20000)
    public void heartBeat(){
        eurekaHttpMethodsService.heartBeat(serviceName, eurekaOperations.buildInstanceID(ipAddress, serverPort, serviceName));
    }
}
