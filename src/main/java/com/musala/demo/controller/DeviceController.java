package com.musala.demo.controller;

import com.musala.demo.model.DeviceCreateRequest;
import com.musala.demo.model.GatewayCreateRequest;
import com.musala.demo.model.MusalaResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.musala.demo.service.DeviceService;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/device/")
public class DeviceController {

	@Autowired
	private DeviceService deviceService;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<MusalaResponce> create(@RequestBody DeviceCreateRequest createRequest) throws Exception{

		String status = deviceService.saveGateway(createRequest);

		MusalaResponce musalaResponce =new MusalaResponce();
		musalaResponce.setResponseCode("000");
		musalaResponce.setResponseObject(status);

		return new ResponseEntity<MusalaResponce>(musalaResponce, HttpStatus.OK);

	}
	
	
}
