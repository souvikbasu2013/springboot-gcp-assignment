package com.gcp.assignment.services;

import java.util.List;
import java.util.Optional;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcp.assignment.entities.BasicDetailsEntity;
import com.gcp.assignment.exception.BasicDetailsNameNotFoundException;
import com.gcp.assignment.exception.BasicDetailsNotFoundException;
import com.gcp.assignment.model.BasicDetails;
import com.gcp.assignment.model.PartyMasterData;

import jakarta.transaction.Transactional;

@Service
public class BasicDetailsService {

	@Autowired com.gcp.assignment.repositories.BasicDetailsRepository BasicDetailsRepository;
	
	@Autowired
    private KieContainer kieContainer;
	
	public List<BasicDetailsEntity> getAllBasicDetailsEntitys() {
		return BasicDetailsRepository.findAll();
	}
	
	public BasicDetailsEntity createBasicDetailsEntity(BasicDetailsEntity BasicDetailsEntity) {
		return BasicDetailsRepository.save(BasicDetailsEntity);
	}
	
	public BasicDetailsEntity getBasicDetailsEntity(String partnerKey) throws BasicDetailsNotFoundException {
		Optional<BasicDetailsEntity> optionalBasicDetailsEntity = BasicDetailsRepository.findByPartnerKey(partnerKey);
		
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
	
	public BasicDetailsEntity updateBasicDetailsEntity(BasicDetailsEntity BasicDetailsEntity, String partnerKey) throws BasicDetailsNotFoundException {
		Optional<BasicDetailsEntity> optionalBasicDetailsEntity = BasicDetailsRepository.findByPartnerKey(partnerKey);
		if(!optionalBasicDetailsEntity.isEmpty()) {
			return BasicDetailsRepository.save(BasicDetailsEntity);
		}else {
			throw new BasicDetailsNotFoundException("BasicDetailsEntity not found with the id...");
		}
	}
	@Transactional
	public void deleteBasicDetailsEntity(String partnerKey) throws BasicDetailsNotFoundException{
		Optional<BasicDetailsEntity> optionalBasicDetailsEntity = BasicDetailsRepository.findByPartnerKey(partnerKey);
		if(!optionalBasicDetailsEntity.isEmpty()) {
			BasicDetailsRepository.deleteByPartnerKey(partnerKey);
		}else {
			throw new BasicDetailsNotFoundException("BasicDetailsEntity not found with the id, please provide correct id...");
		}
		
	}
 
    public void getPartyTypeChecker(BasicDetails basicDetails) {
        KieSession kieSession = kieContainer.newKieSession();
        //kieSession.setGlobal("orderDiscount", orderDiscount);
        kieSession.insert(basicDetails);
        kieSession.fireAllRules();
        kieSession.dispose();
    }
    
    public PartyMasterData getPartyDataValidator(PartyMasterData partyMasterData) {
        KieSession kieSession = kieContainer.newKieSession();
        //kieSession.setGlobal("orderDiscount", orderDiscount);
        kieSession.insert(partyMasterData);
        kieSession.fireAllRules();
        kieSession.dispose();
        return partyMasterData;
    }
}
