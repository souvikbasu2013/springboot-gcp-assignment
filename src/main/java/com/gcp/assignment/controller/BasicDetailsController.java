package com.gcp.assignment.controller;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.gcp.assignment.api.BasicDetailsApi;
import com.gcp.assignment.entities.BasicDetailsEntity;
import com.gcp.assignment.exception.BasicDetailsNotFoundException;
import com.gcp.assignment.model.BasicDetails;
import com.gcp.assignment.model.PartyMasterData;
import com.gcp.assignment.services.BasicDetailsService;
import com.gcp.assignment.services.adapter.PartyConverter;

@RestController
@RequestMapping(value = "/api/v1")
public class BasicDetailsController implements BasicDetailsApi{

	@Autowired
	private BasicDetailsService basicDetailsService;
	
	@GetMapping(path = "/helloWorld")
	public String helloWorld() {
		return "Hello World";
	}
	
	 @RequestMapping(value = "/basic-details/droolsTest-PartyTypeChecker",
		        consumes = { "application/json" }, 
		        method = RequestMethod.POST)
	public void getPartyTypeChecker( @RequestBody BasicDetails basicDetails) {
		basicDetailsService.getPartyTypeChecker(basicDetails);
	}
	 
	 @RequestMapping(value = "/basic-details/droolsTest-PartyDataValidator",
			 	produces = { "application/json" },
		        consumes = { "application/json" }, 
		        method = RequestMethod.POST)
	public PartyMasterData getPartyDataValidator( @RequestBody PartyMasterData partyMasterData) {
		return basicDetailsService.getPartyDataValidator(partyMasterData);
	}

	@Override
	public ResponseEntity<BasicDetails> addBasicDetails(BasicDetails body) {
		BasicDetailsEntity basicDetails = new BasicDetailsEntity();
		basicDetails = PartyConverter.toEntity(body);
		//BeanUtils.copyProperties(body,basicDetails);
		basicDetails =  basicDetailsService.createBasicDetailsEntity(basicDetails);
		BasicDetails basicDetailsDTO = new BasicDetails();
		BeanUtils.copyProperties(basicDetails, basicDetailsDTO);
		return new ResponseEntity<BasicDetails>(basicDetailsDTO,HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Void> deleteBasicDetails(String partnerKey) {
		try{
			basicDetailsService.deleteBasicDetailsEntity(partnerKey);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}catch (BasicDetailsNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

	@Override
	public ResponseEntity<BasicDetails> getBasicDetailsById(String partnerKey) {
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
	public ResponseEntity<BasicDetails> updateBasicDetails(String partnerKey, BasicDetails body) {
		try {
			BasicDetailsEntity basicDetails = new BasicDetailsEntity();
			BeanUtils.copyProperties(body,basicDetails);
			basicDetails = basicDetailsService.updateBasicDetailsEntity(basicDetails, partnerKey);
			BasicDetails basicDetailsDTO = new BasicDetails();
			BeanUtils.copyProperties(basicDetails,basicDetailsDTO);
			return new ResponseEntity<BasicDetails>(basicDetailsDTO,HttpStatus.OK);
		} catch (BasicDetailsNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}
}
