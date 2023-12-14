package com.gcp.assignment.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import io.swagger.annotations.Api;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(BasicDetailsNameNotFoundException.class)
	public final ResponseEntity<Object> handleUserNameNotFoundException(Exception e, WebRequest request){
		
		CustomErrorDetails customError = new CustomErrorDetails(new Date(),  e.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<Object>(customError, HttpStatus.NOT_FOUND);
	}
}
