package com.antoniodanifabio.appservice.discovery;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public class EurekaServiceDiscovery {
	
	@Autowired
	private RestTemplate restTemplate;
	
	public void register(String ip, String port, String appName) {
		String instanceName = buildInstanceID(ip, port, appName);
		String request = "{\n" + 
				"	\"instance\": {\n" + 
				"		\"hostName\": \""+instanceName+"\",\n" + 
				"		\"app\": \""+appName+"\",\n" + 
				"		\"vipAddress\": \"localhost\",\n" + 
				"		\"secureVipAddress\": \"localhost\",\n" + 
				"		\"ipAddr\": \""+ip+"\",\n" + 
				"		\"status\": \"UP\",\n" + 
				"		\"port\": {\"$\": \""+port+"\", \"@enabled\": \"true\"},\n" + 
				"		\"securePort\": {\"$\": \"7091\", \"@enabled\": \"true\"},\n" + 
				"		\"healthCheckUrl\": \"http://"+ip+":"+port+"/healthcheck\",\n" + 
				"		\"statusPageUrl\": \"http://"+ip+":"+port+"/status\",\n" + 
				"		\"homePageUrl\": \"http://"+ip+":"+port+"\",\n" + 
				"		\"dataCenterInfo\": {\n" + 
				"			\"@class\": \"com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo\", \n" + 
				"			\"name\": \"MyOwn\"\n" + 
				"		}\n" + 
				"	}\n" + 
				"}";

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<String> entity = new HttpEntity<String>(request,headers);
		URI url;
		try {
			url = new URI("http://localhost:8080/eureka/v2/apps/" + appName);
			restTemplate.exchange(url, HttpMethod.POST, entity, Void.class);
			
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (HttpClientErrorException e) {
			e.printStackTrace();
		}
	}
	
	public void exclude(String ip, String port, String appID) {
		String instanceID = buildInstanceID(ip, port, appID);
		URI url;
		try {
			url = new URI("http://localhost:8080/eureka/v2/apps/" + appID + "/" + instanceID);
			restTemplate.delete(url);		
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (HttpClientErrorException e) {
			e.printStackTrace();
		}
	}
	
	private String buildInstanceID(String ip, String port, String appName) {
		return String.format("%s_%s_%s", appName, ip, port);
	}
	
}
