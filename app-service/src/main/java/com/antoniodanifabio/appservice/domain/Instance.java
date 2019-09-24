package com.antoniodanifabio.appservice.domain;

import org.springframework.stereotype.Component;

import com.netflix.appinfo.DataCenterInfo;

@Component
public class Instance {
	
	private String hostName;
	private String app;
	private String vipAddress;
	private String secureVipAddress;
	private String ipAddr;
	private String status;
	private Port port;
	private SecurePort securePort;
	private String healthCheckUrl;
	private String statusPageUrl;
	private String homePageUrl;
	private DataCenterInfo dataCenterInfo;
	
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

	public String getVipAddress() {
		return vipAddress;
	}

	public void setVipAddress(String vipAddress) {
		this.vipAddress = vipAddress;
	}

	public String getSecureVipAddress() {
		return secureVipAddress;
	}

	public void setSecureVipAddress(String secureVipAddress) {
		this.secureVipAddress = secureVipAddress;
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

	public Port getPort() {
		return port;
	}

	public void setPort(Port port) {
		this.port = port;
	}

	public SecurePort getSecurePort() {
		return securePort;
	}

	public void setSecurePort(SecurePort securePort) {
		this.securePort = securePort;
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

	public DataCenterInfo getDataCenterInfo() {
		return dataCenterInfo;
	}

	public void setDataCenterInfo(com.netflix.appinfo.DataCenterInfo dataCenterInfo) {
		this.dataCenterInfo = dataCenterInfo;
	}

	public Instance(String hostName, String app, String vipAddress, String secureVipAddress, String ipAddr,
			String status, Port port, SecurePort securePort, String healthCheckUrl, String statusPageUrl,
			String homePageUrl, DataCenterInfo dataCenterInfo2) {
		this.hostName = hostName;
		this.app = app;
		this.vipAddress = vipAddress;
		this.secureVipAddress = secureVipAddress;
		this.ipAddr = ipAddr;
		this.status = status;
		this.port = port;
		this.securePort = securePort;
		this.healthCheckUrl = healthCheckUrl;
		this.statusPageUrl = statusPageUrl;
		this.homePageUrl = homePageUrl;
		this.dataCenterInfo = dataCenterInfo2;
	}
	
}
