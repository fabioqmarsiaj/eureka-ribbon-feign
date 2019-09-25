package com.antoniodanifabio.playlistservice.discovery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.antoniodanifabio.playlistservice.domain.Instance;
import com.google.gson.Gson;
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
    private Instance instance;
    @Autowired
    private  EurekaFeign eurekaFeign;
  

    public void register(){
    	
    	instance.setHostName(buildInstanceID(ipAddress, serverPort, serviceName));
    	instance.setApp(serviceName);
    	instance.setIpAddr(ipAddress);
    	instance.setPort(1);
    	instance.setSecurePort(1);
    	instance.setHealthCheckUrl("http://localhost:"+serverPort+"/healthcheck");
    	instance.setStatusPageUrl("http://localhost:"+serverPort+"/status");
    	instance.setHomePageUrl("http://localhost:"+serverPort);
    	instance.setDataCenterInfo(new MyDataCenterInfo(Name.MyOwn));
    	instance.getDataCenterInfo().getClass();
    	Gson gson = new Gson();
    	
    	String instanceString = gson.toJson(instance);
    	
    	System.out.println("instance:" + instanceString);
    	
        eurekaFeign.getFeignBuilder().registry(
        		"instance:" + instanceString
        , serviceName);
        eurekaFeign.getFeignBuilder().updateToUP(serviceName, buildInstanceID(ipAddress, serverPort, serviceName));
    }

    public void delete(){
        eurekaFeign.getFeignBuilder().delete(serviceName, buildInstanceID(ipAddress, serverPort, serviceName));
    }

    private String buildInstanceID(String ip, String port, String appName) {
        return String.format("%s_%s_%s", appName, ip, port);
    }
}
