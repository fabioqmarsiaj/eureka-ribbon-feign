package com.antoniodanifabio.appservice.domain;

public class Port {
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
	public Port(String $, Boolean enabled) {
		this.$ = $;
		this.enabled = enabled;
	}
	public Port() {
	}
	
	
}
