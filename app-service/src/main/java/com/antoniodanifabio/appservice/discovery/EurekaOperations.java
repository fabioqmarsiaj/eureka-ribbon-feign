package com.antoniodanifabio.appservice.discovery;

import java.io.IOException;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.netflix.appinfo.DataCenterInfo;
import com.netflix.appinfo.DataCenterInfo.Name;
import com.antoniodanifabio.appservice.domain.Instance;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.appinfo.InstanceInfo.ActionType;
import com.netflix.appinfo.InstanceInfo.InstanceStatus;
import com.netflix.appinfo.InstanceInfo.PortType;
import com.netflix.appinfo.MyDataCenterInfo;
import com.netflix.discovery.converters.jackson.DataCenterTypeInfoResolver;

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
    
    public void register() throws IOException, JSONException{
    	Instance instance = new Instance(hostName);
    	System.out.println(instance.toString());
    	
    	eurekaFeign.getFeignBuilder().registry(instance.toString(), serviceName);
    	eurekaFeign.getFeignBuilder().updateToUP(serviceName, hostName);
    }

    public void delete(){
    	eurekaFeign.getFeignBuilder().delete(serviceName, hostName);
    }
}
