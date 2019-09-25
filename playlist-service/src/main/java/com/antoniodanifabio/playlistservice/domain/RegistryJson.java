package com.antoniodanifabio.playlistservice.domain;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class RegistryJson {
	
	private String hostName;
	private String app;
	private final String vipAddress = "com.localhost";
	private final String secureVipAddress = "com.localhost";
	private String ipAddr;
	private String status = "STARTING";
	private List<String> port;
	private List<String> securePort;
	private String healthCheckUrl;
	private String statusPageUrl;
	private String homePageUrl;
	private List<String> dataCenterInfo;
	
	public RegistryJson() {
		super();
		port = new ArrayList<String>();
		securePort = new ArrayList<String>();
		dataCenterInfo = new ArrayList<String>();
	}
	
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public String getApp() {
		return app;
	}
	public void setApp(String app) {
		this.app = app;
	}
	public String getIpAddr() {
		return ipAddr;
	}
	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<String> getPort() {
		return port;
	}
	public List<String> getSecurePort() {
		return securePort;
	}
	public String getHealthCheckUrl() {
		return healthCheckUrl;
	}
	public void setHealthCheckUrl(String healthCheckUrl) {
		this.healthCheckUrl = healthCheckUrl;
	}
	public String getStatusPageUrl() {
		return statusPageUrl;
	}
	public void setStatusPageUrl(String statusPageUrl) {
		this.statusPageUrl = statusPageUrl;
	}
	public String getHomePageUrl() {
		return homePageUrl;
	}
	public void setHomePageUrl(String homePageUrl) {
		this.homePageUrl = homePageUrl;
	}
	public List<String> getDataCenterInfo() {
		return dataCenterInfo;
	}
	public String getVipAddress() {
		return vipAddress;
	}
	public String getSecureVipAddress() {
		return secureVipAddress;
	}
	
	
	
	
	
	

}
