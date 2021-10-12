package com.musala.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GatewayCreateRequest {
	
	    private Integer id;
	
	    private String serial;

	    private String name;

	    private String ip;

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

		
		
		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("GatewayCreateRequest [id=");
			builder.append(id);
			builder.append(", serial=");
			builder.append(serial);
			builder.append(", name=");
			builder.append(name);
			builder.append(", ip=");
			builder.append(ip);
			builder.append("]");
			return builder.toString();
		}
}
