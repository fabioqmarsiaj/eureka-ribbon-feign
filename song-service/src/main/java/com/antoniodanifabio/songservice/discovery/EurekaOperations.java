package com.antoniodanifabio.songservice.discovery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.antoniodanifabio.songservice.domain.Instance;
import com.netflix.appinfo.DataCenterInfo.Name;
import com.netflix.appinfo.MyDataCenterInfo;

@Component
public class EurekaOperations {

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
    @Autowired
    private Instance instance;
    
    public void register(){
    	instance.setHostName(buildInstanceID(ipAddress, serverPort, serviceName));
    	instance.setApp(serviceName);
    	instance.setIpAddr(ipAddress);
    	instance.setPort(serverPort);
    	instance.setSecurePort(serverPort);
    	instance.setHealthCheckUrl("http://localhost:"+serverPort+"/healthcheck");
    	instance.setStatusPageUrl("http://localhost:"+serverPort+"/status");
    	instance.setHomePageUrl("http://localhost:"+serverPort);
    	instance.setDataCenterInfo(new MyDataCenterInfo(Name.MyOwn));
    	
        eurekaFeign.getFeignBuilder().registry(instance.toString(), serviceName);
        eurekaFeign.getFeignBuilder().updateToUP(serviceName, buildInstanceID(ipAddress, serverPort, serviceName));
    }

    public void delete(){
    	eurekaFeign.getFeignBuilder().delete(serviceName, buildInstanceID(ipAddress, serverPort, serviceName));
    }
    
    private String buildInstanceID(String ip, String port, String appName) {
        return String.format("%s_%s_%s", appName, ip, port);
    }

}
