package com.gcp.assignment.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.gcp.assignment.entities.BasicDetailsEntity;
import com.gcp.assignment.exception.*;

@Service
public class BasicDetailsService {

	@Autowired com.gcp.assignment.repositories.BasicDetailsRepository BasicDetailsRepository;
	
	public List<BasicDetailsEntity> getAllBasicDetailsEntitys() {
		return BasicDetailsRepository.findAll();
	}
	
	public BasicDetailsEntity createBasicDetailsEntity(BasicDetailsEntity BasicDetailsEntity) {
		return BasicDetailsRepository.save(BasicDetailsEntity);
	}
	
	public BasicDetailsEntity getBasicDetailsEntity(Long id) throws BasicDetailsNotFoundException {
		Optional<BasicDetailsEntity> optionalBasicDetailsEntity = BasicDetailsRepository.findById(id);
		
		return optionalBasicDetailsEntity.orElseThrow(() ->  new BasicDetailsNotFoundException("BasicDetails not found with the partnerKey..."));
		/*
		 * if(!optionalBasicDetailsEntity.isEmpty()) { return optionalBasicDetailsEntity.get(); }else { throw new
		 * BasicDetailsEntityNotFoundException("BasicDetailsEntity not found with the id..."); }
		 */
	}
	
	public BasicDetailsEntity getBasicDetailsEntityByName(String BasicDetailsEntityname) throws BasicDetailsNameNotFoundException {
		List<BasicDetailsEntity> optionalBasicDetailsEntity = BasicDetailsRepository.findByFirstName(BasicDetailsEntityname);
		if(optionalBasicDetailsEntity!=null && optionalBasicDetailsEntity.size()>0) {
			return optionalBasicDetailsEntity.get(0);
		}else {
			throw new BasicDetailsNameNotFoundException("BasicDetailsEntity Name "+BasicDetailsEntityname+" not found in the repository...");
		}
	}
	
	public BasicDetailsEntity updateBasicDetailsEntity(BasicDetailsEntity BasicDetailsEntity, Long id) throws BasicDetailsNotFoundException {
		Optional<BasicDetailsEntity> optionalBasicDetailsEntity = BasicDetailsRepository.findById(id);
		if(!optionalBasicDetailsEntity.isEmpty()) {
			return BasicDetailsRepository.save(BasicDetailsEntity);
		}else {
			throw new BasicDetailsNotFoundException("BasicDetailsEntity not found with the id...");
		}
	}
	
	public void deleteBasicDetailsEntity(Long id) throws BasicDetailsNotFoundException{
		Optional<BasicDetailsEntity> optionalBasicDetailsEntity = BasicDetailsRepository.findById(id);
		if(!optionalBasicDetailsEntity.isEmpty()) {
			BasicDetailsRepository.deleteById(id);
		}else {
			throw new BasicDetailsNotFoundException("BasicDetailsEntity not found with the id, please provide correct id...");
		}
		
	}
}
