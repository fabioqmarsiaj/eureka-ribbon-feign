package com.antoniodanifabio.playlistservice.domain;

import org.springframework.stereotype.Component;
import com.netflix.appinfo.MyDataCenterInfo;

@Component
public class Instance {
	
	private String hostName;
	private String app;
	private final String vipAddress = "com.localhost";
	private final String secureVipAddress = "com.localhost";
	private String ipAddr;
	private String status = "STARTING";
	private String port;
	private String securePort;
	private String healthCheckUrl;
	private String statusPageUrl;
	private String homePageUrl;
	private MyDataCenterInfo dataCenterInfo;
	
	public Instance() {
		super();
	}
	
	public void setPort(String port) {
		this.port = port;
	}
	public void setSecurePort(String securePort) {
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
	public String getPort() {
		return port;
	}
	public String getSecurePort() {
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
		return "{\n" +
                "   \"instance\":{\n" +
                "      \"hostName\":\"" + hostName + "\",\n" +
                "      \"app\":\"" + app + "\",\n" +
                "      \"vipAddress\":\"" + vipAddress + "\",\n" +
                "      \"secureVipAddress\":\""+ secureVipAddress +"\",\n" +
                "      \"ipAddr\":\"" + ipAddr + "\",\n" +
                "      \"status\":\"" + status + "\",\n" +
                "      \"port\":{\n" +
                "         \"$\":\"" + port + "\",\n" +
                "         \"@enabled\":\"true\"\n" +
                "      },\n" +
                "      \"securePort\":{\n" +
                "         \"$\":\"8431\",\n" +
                "         \"@enabled\":\"true\"\n" +
                "      },\n" +
                "      \"healthCheckUrl\":\"" + healthCheckUrl + "\",\n" +
                "      \"statusPageUrl\":\"" + statusPageUrl + "\",\n" +
                "      \"homePageUrl\":\"" + homePageUrl + "\",\n" +
                "      \"dataCenterInfo\":{\n" +
                "         \"@class\":\"com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo\",\n" +
                "         \"name\":\"" + dataCenterInfo.getName() + "\"\n" +
                "      }\n" +
                "   }\n" +
                "}";
	}
	
}
