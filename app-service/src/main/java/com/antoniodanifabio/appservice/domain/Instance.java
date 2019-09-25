package com.antoniodanifabio.appservice.domain;

public class Instance {
	
	private String hostName;
	private String app;
	private String vipAddress;
	private String secureVipAddress;
	private String ipAddr;
	private String status;
	private String port;
	private String securePort;
	private String healthCheckUrl;
	private String statusPageUrl;
	private String homePageUrl;
	private String dataCenterInfo;
	
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

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getSecurePort() {
		return securePort;
	}

	public void setSecurePort(String securePort) {
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

	public String getDataCenterInfo() {
		return dataCenterInfo;
	}

	public void setDataCenterInfo(String defaultDataCenterInfo) {
		this.dataCenterInfo = defaultDataCenterInfo;
	}

	public Instance(String hostName, String app, String vipAddress, String secureVipAddress, String ipAddr,
			String status, String port, String securePort, String healthCheckUrl, String statusPageUrl,
			String homePageUrl, String dataCenterInfo) {
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
		this.dataCenterInfo = dataCenterInfo;
	}
	
	@Override
	public String toString() {
		return "{\n" +
                "   \"instance\":{\n" +
                "      \"hostName\":\"" + hostName + "\",\n" +
                "      \"app\":\"app-service\",\n" +
                "      \"vipAddress\":\"com.localhost\",\n" +
                "      \"secureVipAddress\":\"com.localhost\",\n" +
                "      \"ipAddr\":\"localhost\",\n" +
                "      \"status\":\"STARTING\",\n" +
                "      \"port\":{\n" +
                "         \"$\":\"8081\",\n" +
                "         \"@enabled\":\"true\"\n" +
                "      },\n" +
                "      \"securePort\":{\n" +
                "         \"$\":\"8431\",\n" +
                "         \"@enabled\":\"true\"\n" +
                "      },\n" +
                "      \"healthCheckUrl\":\"http://localhost:8081/healthcheck\",\n" +
                "      \"statusPageUrl\":\"http://localhost:8081/status\",\n" +
                "      \"homePageUrl\":\"http://localhost:8081\",\n" +
                "      \"dataCenterInfo\":{\n" +
                "         \"@class\":\"com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo\",\n" +
                "         \"name\":\"MyOwn\"\n" +
                "      }\n" +
                "   }\n" +
                "}";
	}

	public Instance(String hostName) {
		this.hostName = hostName;
	}
	
}
