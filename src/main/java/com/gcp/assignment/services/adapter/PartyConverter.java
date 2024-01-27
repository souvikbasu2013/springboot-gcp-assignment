package com.gcp.assignment.services.adapter;

import java.util.ArrayList;
import java.util.List;

import com.gcp.assignment.entities.AddressEntity;
import com.gcp.assignment.entities.BasicDetailsEntity;
import com.gcp.assignment.entities.PartyEntity;
import com.gcp.assignment.model.Address;
import com.gcp.assignment.model.BasicDetails;
import com.gcp.assignment.model.Party;

public final class PartyConverter {

	private PartyConverter(){
		
	}
	public static BasicDetailsEntity toEntity(BasicDetails dtoObject){
		
		BasicDetailsEntity BasicDetailsEntity =new BasicDetailsEntity();
		PartyEntity tempParty = new PartyEntity();
		BasicDetailsEntity.setAge(dtoObject.getAge());
		BasicDetailsEntity.setDob(dtoObject.getDob());
		BasicDetailsEntity.setFirstName(dtoObject.getFirstName());
		BasicDetailsEntity.setLastName(dtoObject.getLastName());
		BasicDetailsEntity.setPartnerKey(dtoObject.getPartnerKey());
		BasicDetailsEntity.setId(dtoObject.getId());
		if(dtoObject.getPartyDetails()!=null) {
			tempParty.setPartyNumber(dtoObject.getPartyDetails().getPartyNumber());
			tempParty.setCreatedBy(dtoObject.getPartyDetails().getCreatedBy());
			tempParty.setCreatedDate(dtoObject.getPartyDetails().getCreatedDate());
			tempParty.setPartyType(dtoObject.getPartyDetails().getPartyType().toString());
			tempParty.setUpdateddBy(dtoObject.getPartyDetails().getUpdatedBy());
			tempParty.setUpdatedDate(dtoObject.getPartyDetails().getUpdatedDate());
			tempParty.setPartyId(dtoObject.getPartyDetails().getPartyId());
			BasicDetailsEntity.setParty(tempParty);
		}
		if(!dtoObject.getAddresses().isEmpty()) {
			List<AddressEntity> addrList = new ArrayList<>(dtoObject.getAddresses().size());
			for(Address addr : dtoObject.getAddresses()) {
				AddressEntity tempAddr = new AddressEntity();
				tempAddr.setAddressId(addr.getAddressId());
				tempAddr.setAddressType(addr.getAddressType().toString());
				tempAddr.setStreetName(addr.getAddressStates().get(0).getStreetName());
				tempAddr.setPobox(addr.getAddressStates().get(0).getPobox());
				tempAddr.setCountryCode(addr.getAddressStates().get(0).getCountryCode());
				tempAddr.setBasicDetail(BasicDetailsEntity);
				addrList.add(tempAddr);
			}
			BasicDetailsEntity.setAddress(addrList);
		}
		return BasicDetailsEntity;
	}
	
	/*
	 * public static CampaignDto toDto(Campaign model){ CampaignDto campaign=new
	 * CampaignDto(); campaign.setCampaignId(model.getCampaignId());
	 * campaign.setCampaignName(model.getName());
	 * campaign.setFinancialYr(model.getFinancialYr());
	 * campaign.setStartDt(model.getStartDt());
	 * campaign.setStatusId(model.getStatusId());
	 * campaign.setStatusDesc(model.getStatusId()==1?CampaignManagementStatusEnum.
	 * CREATION.getDescription():(model.getStatusId()==2?
	 * CampaignManagementStatusEnum.SENT.getDescription():
	 * CampaignManagementStatusEnum.CLOSED.getDescription()));
	 * campaign.setCreateId(model.getCreateId());
	 * campaign.setCreateTmstmp(model.getCreateTmstmp());
	 * campaign.setUpdateId(model.getUpdtId());
	 * campaign.setUpdtTmstmp(model.getUpdtTmstmp()); return campaign; }
	 * 
	 * public static CampaignDto toCampaignDto(CampaignFrnEmailMapping model){
	 * return CampaignConverter.toDto(model.getCampaign()); }
	 */

}
