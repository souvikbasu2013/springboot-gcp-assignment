package com.gcp.assignment.exception;

public class BasicDetailsNotFoundException extends Exception{

	private String message;
	public BasicDetailsNotFoundException(String message) {
		super(message);
	}
}
