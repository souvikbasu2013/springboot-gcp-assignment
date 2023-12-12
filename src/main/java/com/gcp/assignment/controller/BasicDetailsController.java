package com.gcp.assignment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/basic-details/")
public class BasicDetailsController {

	@GetMapping(path = "/helloWorld")
	public String helloWorld() {
		return "Hello World";
	}

}
