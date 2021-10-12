package com.musala.demo.controller;

import java.io.PrintWriter;
import java.io.StringWriter;

import com.musala.demo.exception.MusalaException;
import com.musala.demo.model.MusalaError;
import com.musala.demo.model.MusalaResponce;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

Log logger = LogFactory.getLog(GlobalExceptionHandler.class);
	
	@ExceptionHandler(value = MusalaException.class)
	public ResponseEntity<MusalaResponce> handleIpayException(MusalaException error) {
		
		StringWriter stack = new StringWriter();
		error.printStackTrace(new PrintWriter(stack));
		
		logger.	info("Start logging Ipay Exception...");
		logger.error("Error Code :: "+error.getErrorCode());
		logger.error("Error Message :: "+error.getErrorMessage());
		logger.info("Logging Exception Details...");
		logger.info("Class Name :: "+error.getStackTrace()[0].getClassName());
		logger.info("Method Name :: "+error.getStackTrace()[0].getMethodName());
		logger.info("Line Number :: "+error.getStackTrace()[0].getLineNumber());
		logger.info("Done logging Ipay Exception...\n");
		
		MusalaError ipayError = new MusalaError();
		ipayError.setErrorCode(error.getErrorCode());
		ipayError.setErrorMessage(error.getErrorMessage());

		MusalaResponce response = new MusalaResponce();
		response.setResponseCode("999");
		response.setResponseObject(ipayError);
		
		return new ResponseEntity<MusalaResponce>(response, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<MusalaResponce> handleGenericException(Exception error) {
		
		StringWriter stack = new StringWriter();
		error.printStackTrace(new PrintWriter(stack));
		
		logger.info("Start logging Unhandled Exception...");
		logger.info("Logging Stack Trace...");
		logger.error(stack.toString());
		logger.info("Done logging Unhandled Exception...\n");

		MusalaError ipayError = new MusalaError();
		ipayError.setErrorCode("999");
		ipayError.setErrorMessage(error.getMessage() != null ? error.getMessage() : "Server error. Please try again later.");
		
		if(error instanceof ObjectOptimisticLockingFailureException) {
			ipayError.setErrorMessage("The record was updated or deleted by another transaction. Please try again later.");
		}

		MusalaResponce response = new MusalaResponce();
		response.setResponseCode("999");
		response.setResponseObject(ipayError);
		
		return new ResponseEntity<MusalaResponce>(response, HttpStatus.BAD_REQUEST);

		
	}
	
}
