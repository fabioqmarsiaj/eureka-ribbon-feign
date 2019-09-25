package com.antoniodanifabio.playlistservice.domain;

import org.springframework.stereotype.Component;
import com.netflix.appinfo.DataCenterInfo;
import com.netflix.appinfo.MyDataCenterInfo;

@Component
public class Instance {
	
	private String hostName;
	private String app;
	private final String vipAddress = "com.localhost";
	private final String secureVipAddress = "com.localhost";
	private String ipAddr;
	private String status = "STARTING";
	private Integer port;
	private Integer securePort;
	private String healthCheckUrl;
	private String statusPageUrl;
	private String homePageUrl;
	private MyDataCenterInfo dataCenterInfo;
	
	public Instance() {
		super();
	}
	
	public void setPort(Integer port) {
		this.port = port;
	}
	public void setSecurePort(Integer securePort) {
		this.securePort = securePort;
	}
	public MyDataCenterInfo getDataCenterInfo() {
		return dataCenterInfo;
	}
	public void setDataCenterInfo(MyDataCenterInfo myDataCenterInfo) {
		this.dataCenterInfo = myDataCenterInfo;
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
	public Integer getPort() {
		return port;
	}
	public Integer getSecurePort() {
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
	public String getVipAddress() {
		return vipAddress;
	}
	public String getSecureVipAddress() {
		return secureVipAddress;
	}

	@Override
	public String toString() {
		return "instance: {hostName:" + hostName + ", app:" + app + ", vipAddress:" + vipAddress + ", secureVipAddress:"
				+ secureVipAddress + ", ipAddr:" + ipAddr + ", status:" + status + ", port:" + port + ", securePort:"
				+ securePort + ", healthCheckUrl:" + healthCheckUrl + ", statusPageUrl:" + statusPageUrl
				+ ", homePageUrl:" + homePageUrl + ", dataCenterInfo:" + dataCenterInfo;
	}
	
	
}
