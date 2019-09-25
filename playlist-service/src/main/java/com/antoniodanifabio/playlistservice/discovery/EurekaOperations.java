package com.antoniodanifabio.playlistservice.discovery;

import feign.Feign;
import feign.gson.GsonDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.antoniodanifabio.playlistservice.domain.RegistryJson;

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
    private RegistryJson registryJson;

    private  EurekaHttpClient eurekaHttpMethodsService = Feign
            .builder()
            .decoder(new GsonDecoder())
            .target(EurekaHttpClient.class, "http://localhost:8080/eureka/v2/apps");

    public void register(){
    	
    	registryJson.setHostName(buildInstanceID(ipAddress, serverPort, serviceName));
    	registryJson.setApp(serviceName);
    	registryJson.setIpAddr(ipAddress);
    	registryJson.getPort().add(serverPort);
    	registryJson.getPort().add("true");
    	registryJson.getSecurePort().add("8443");
    	registryJson.getSecurePort().add("true");
    	registryJson.setHealthCheckUrl("http://localhost:"+serverPort+"healthcheck");
    	registryJson.setStatusPageUrl("http://localhost:"+serverPort+"status");
    	registryJson.setHomePageUrl("http://localhost:"+serverPort);
    	registryJson.getDataCenterInfo().add("com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo");
    	registryJson.getDataCenterInfo().add("MyOwn");
    	
        eurekaHttpMethodsService.registry(
                "{\n" +
                        "    \"instance\": {\n" +
                        "        \"hostName\": \""+ buildInstanceID(ipAddress, serverPort, serviceName) +"\",\n" +
                        "        \"app\": \""+ serviceName +"\",\n" +
                        "        \"vipAddress\": \"com.localhost\",\n" +
                        "        \"secureVipAddress\": \"com.localhost\",\n" +
                        "        \"ipAddr\": \""+ipAddress+"\",\n" +
                        "        \"status\": \"STARTING\",\n" +
                        "        \"port\": {\"$\": \"" + serverPort + "\", \"@enabled\": \"true\"},\n" +
                        "        \"securePort\": {\"$\": \"8443\", \"@enabled\": \"true\"},\n" +
                        "        \"healthCheckUrl\": \"http://localhost:"+serverPort+"/healthcheck\",\n" +
                        "        \"statusPageUrl\": \"http://localhost:"+serverPort+"/status\",\n" +
                        "        \"homePageUrl\": \"http://localhost:"+serverPort+"\",\n" +
                        "        \"dataCenterInfo\": {\n" +
                        "            \"@class\": \"com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo\",\n" +
                        "            \"name\": \"MyOwn\"\n" +
                        "        }\n" +
                        "    }\n" +
                        "}"
        , serviceName);
        eurekaHttpMethodsService.updateToUP(serviceName, buildInstanceID(ipAddress, serverPort, serviceName));
    }

    public void delete(){
        eurekaHttpMethodsService.delete(serviceName, buildInstanceID(ipAddress, serverPort, serviceName));
    }

    private String buildInstanceID(String ip, String port, String appName) {
        return String.format("%s_%s_%s", appName, ip, port);
    }
}
