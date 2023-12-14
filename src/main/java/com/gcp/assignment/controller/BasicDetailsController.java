package com.gcp.assignment.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.gcp.assignment.api.BasicDetailsApi;
import com.gcp.assignment.entities.BasicDetailsEntity;
import com.gcp.assignment.exception.BasicDetailsNotFoundException;
import com.gcp.assignment.model.BasicDetails;
import com.gcp.assignment.services.BasicDetailsService;

@RestController
//@RequestMapping(value = "/basic-details/")
public class BasicDetailsController implements BasicDetailsApi{

	@Autowired
	private BasicDetailsService basicDetailsService;
	
	@GetMapping(path = "/helloWorld")
	public String helloWorld() {
		return "Hello World";
	}

	@Override
	public ResponseEntity<Integer> addBasicDetails(BasicDetails body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> deleteBasicDetails(Long partnerKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<BasicDetails> getBasicDetailsById(Long partnerKey) {
		 try {
				BasicDetailsEntity basicDetails= basicDetailsService.getBasicDetailsEntity(partnerKey);
				BasicDetails basicDetailsDTO = new BasicDetails();
				BeanUtils.copyProperties(basicDetails, basicDetailsDTO);
				return new ResponseEntity<BasicDetails>(basicDetailsDTO,HttpStatus.OK);
			} catch (BasicDetailsNotFoundException e) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
			}
	}

	@Override
	public ResponseEntity<BasicDetails> updateBasicDetails(Long partnerKey, BasicDetails body) {
		// TODO Auto-generated method stub
		return null;
	}

}
