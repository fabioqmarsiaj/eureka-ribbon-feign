package com.antoniodanifabio.appservice.domain;

public class SecurePort {
	private String $;
	private Boolean enabled;
	public String get$() {
		return $;
	}
	public void set$(String $) {
		this.$ = $;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	public SecurePort(String $, Boolean enabled) {
		this.$ = $;
		this.enabled = enabled;
	}
	public SecurePort() {
	}
	
	
}
