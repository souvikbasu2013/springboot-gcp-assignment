package com.gcp.assignment.entities;

import java.util.List;

/*import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;*/

import org.springframework.validation.annotation.Validated;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "This model is to create a Audit Detail")
@Entity(name="PartyEntity")
@Table(name="party")
@Validated
@Data
@NoArgsConstructor
public class PartyEntity {
	@ApiModelProperty(notes = "Auto generated unique id", required = true)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	@Column(name = "PARTYID")
	private Long partyId;
	
	@Column(name = "PARTY_NUMBER", length = 50, nullable = true)
	@Size(min = 2,message = "PARTY_NUMBER should be atleast 2 characters")
	private String partyNumber;
	
	@Column(name = "PARTY_TYPE", length = 50, nullable = true)
	@Size(min = 2,message = "PARTY_TYPE should be atleast 2 characters")
	private String partyType;
	
	@Column(name = "CREATED_BY", length = 50, nullable = true)
	@Size(min = 2,message = "CREATED_BY should be atleast 2 characters")
	private String createdBy;
	
	@Column(name = "CREATED_DATE", length = 50, nullable = true)
	private String createdDate;
	
	@Column(name = "UPDATED_BY", length = 50, nullable = true)
	@Size(min = 2,message = "UPDATED_BY should be atleast 2 characters")
	private String updateddBy;
	
	@Column(name = "UPDATED_DATE", length = 50, nullable = true)
	private String updatedDate;
	
	
}
