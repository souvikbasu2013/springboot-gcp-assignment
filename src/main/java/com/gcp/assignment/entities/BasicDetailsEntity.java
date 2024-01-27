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

@ApiModel(description = "This model is to create a Basic Details")
@Entity(name="BasicDetailsEntity")
@Table(name="basic_detail")
@Validated
@Data
@NoArgsConstructor
public class BasicDetailsEntity {

	@ApiModelProperty(notes = "Auto generated unique id", required = true)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "PARTNERKEY", length = 50, nullable = true)
	@Size(min = 2,message = "First Name should be atleast 2 characters")
	private String partnerKey;
	
	@Column(name = "FIRST_NAME", length = 50, nullable = true)
	@Size(min = 2,message = "First Name should be atleast 2 characters")
	private String firstName;
	
	@Column(name = "LAST_NAME", length = 50, nullable = true)
	private String lastName;
	
	@ApiModelProperty(notes = "Age", required = true)
	@Column(name = "AGE", length = 50, nullable = false)
	private Long age;
	
	@ApiModelProperty(notes = "Social Security Number", required = true)
	@Column(name = "DOB", length = 50, nullable = false)
	private String dob;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PARTYID", referencedColumnName = "PARTYID")
    private PartyEntity party;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "basicDetail", cascade = CascadeType.ALL)
    private List<AddressEntity> address;
	
}
