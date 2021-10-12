package com.musala.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GatewayCreateRespose {

    private Integer id;
    private String serial;
    private String name;
    private String ip;

	public GatewayCreateRespose(Integer id, String serial, String name, String ip) {
		super();
		this.id = id;
		this.serial = serial;
		this.name = name;
		this.ip = ip;
	}
	
	public GatewayCreateRespose() {	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

}
