package com.gcp.assignment.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gcp.assignment.entities.BasicDetailsEntity;

@Repository
public interface BasicDetailsRepository extends JpaRepository<BasicDetailsEntity, Long>{
	List<BasicDetailsEntity> findByFirstName(String username);
	Optional<BasicDetailsEntity> findByPartnerKey(String partnerKey);
	Long deleteByPartnerKey(String partnerKey);
}
