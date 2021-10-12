package com.musala.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.musala.demo.model.GatewayCreateRequest;
import com.musala.demo.model.GatewayCreateRespose;
import com.musala.demo.model.MusalaResponce;
import com.musala.demo.service.GatewayService;

@Controller
@RequestMapping("/gateway/")
public class MusalaController {
	
	@Autowired
	private GatewayService gatewayService;

    @RequestMapping(value = "/{id}/runner", method = RequestMethod.GET)
    public ResponseEntity<String> runner(@PathVariable("id") int id) throws Exception{

        String s = String.valueOf(id);

        return new ResponseEntity<String>(s, HttpStatus.OK);
    }

    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<MusalaResponce> create(@RequestBody GatewayCreateRequest createRequest) throws Exception{

    	String status = gatewayService.saveGateway(createRequest);
    	
    	MusalaResponce musalaResponce =new MusalaResponce();
    	musalaResponce.setResponseCode("000");
    	musalaResponce.setResponseObject(status);
    	
    	return new ResponseEntity<MusalaResponce>(musalaResponce, HttpStatus.OK);
    	
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<MusalaResponce> update(@RequestBody GatewayCreateRequest createRequest) throws Exception{

    	String status = gatewayService.updateGateway(createRequest);
    	
    	MusalaResponce musalaResponce =new MusalaResponce();
    	musalaResponce.setResponseCode("000");
    	musalaResponce.setResponseObject(status);
    	
    	return new ResponseEntity<MusalaResponce>(musalaResponce, HttpStatus.OK);
    	
    }
    
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<MusalaResponce> getAll() throws Exception{

    	List<GatewayCreateRespose> createResposes = gatewayService.getAll();
    	
    	MusalaResponce musalaResponce =new MusalaResponce();
    	musalaResponce.setResponseCode("000");
    	musalaResponce.setResponseObject(createResposes);
    	
    	return new ResponseEntity<MusalaResponce>(musalaResponce, HttpStatus.OK);
    	
    }
    
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<MusalaResponce> getById(@PathVariable("id") int id ) throws Exception{

    	GatewayCreateRespose createRespose = gatewayService.getById(id);
    	
    	MusalaResponce musalaResponce =new MusalaResponce();
    	musalaResponce.setResponseCode("000");
    	musalaResponce.setResponseObject(createRespose);
    	
    	return new ResponseEntity<MusalaResponce>(musalaResponce, HttpStatus.OK);
    	
    }
    

}
