package com.musala.demo.service;

import java.util.List;

import com.musala.demo.model.GatewayCreateRequest;
import com.musala.demo.model.GatewayCreateRespose;

public interface GatewayService {
	
	String saveGateway(GatewayCreateRequest createRequest);
	
	String updateGateway(GatewayCreateRequest createRequest);
	
	List<GatewayCreateRespose>  getAll();
	
	GatewayCreateRespose getById(int id);	
	
	
}


