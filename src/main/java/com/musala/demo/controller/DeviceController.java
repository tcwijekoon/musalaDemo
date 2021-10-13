package com.musala.demo.controller;

import com.musala.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.musala.demo.service.DeviceService;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/device/")
public class DeviceController {

	@Autowired
	private DeviceService deviceService;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<MusalaResponce> create(@RequestBody DeviceCreateRequest createRequest) throws Exception{

		String status = deviceService.saveDevice(createRequest);

		MusalaResponce musalaResponce =new MusalaResponce();
		musalaResponce.setResponseCode("000");
		musalaResponce.setResponseObject(status);

		return new ResponseEntity<MusalaResponce>(musalaResponce, HttpStatus.OK);

	}

	@RequestMapping(value = "gateway/{id}", method = RequestMethod.GET)
	public ResponseEntity<MusalaResponce> getAllByGatewayId(@PathVariable("id") int gatewayId) throws Exception{

		List<DeviceResponse> deviceResponses = deviceService.getDeviceByGatewayId(gatewayId);

		MusalaResponce musalaResponce =new MusalaResponce();
		musalaResponce.setResponseCode("000");
		musalaResponce.setResponseObject(deviceResponses);

		return new ResponseEntity<MusalaResponce>(musalaResponce, HttpStatus.OK);

	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<MusalaResponce> deleteDvice(@PathVariable("id") int id) throws Exception{

		String statuss = deviceService.deleteDevice(id);

		MusalaResponce musalaResponce =new MusalaResponce();
		musalaResponce.setResponseCode("000");
		musalaResponce.setResponseObject(statuss);

		return new ResponseEntity<MusalaResponce>(musalaResponce, HttpStatus.OK);

	}
	
}
