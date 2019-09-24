package com.antoniodanifabio.playlistservice.domain;

import java.util.List;

import javax.sound.sampled.Port;

import com.netflix.appinfo.InstanceInfo;

public class RegistryJson {
	
	private String hostName;
	private String app;
	private final String vipAddress = "com.localhost";
	private final String secureVipAddress = "com.localhost";
	private String ipAddr;
	private String status = "STARTING";
	private Port port;
	private final String securePort = "8443";
	private String healthCheckUrl;
	private String statusPageUrl;
	private String homePageUrl;
	private InstanceInfo dataCenterInfo;
	
	
	

}
