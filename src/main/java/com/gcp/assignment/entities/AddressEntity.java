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

@ApiModel(description = "This model is to create a address Details")
@Entity(name="AddressEntity")
@Table(name="address_detail")
@Validated
@Data
@NoArgsConstructor
public class AddressEntity {

	@ApiModelProperty(notes = "Auto generated unique id", required = true)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	@Column(name = "ADDRESSID")
	private Integer addressId;
	
	@Column(name = "ADDRESS_TYPE", length = 50, nullable = true)
	@Size(min = 2,message = "First Name should be atleast 2 characters")
	private String addressType;
	
	@Column(name = "STREET_NAME", length = 50, nullable = true)
	@Size(min = 2,message = "Street Name should be atleast 2 characters")
	private String streetName;
	
	@Column(name = "POBOX", length = 10, nullable = true)
	private String pobox;
	
	@ApiModelProperty(notes = "countryCode")
	@Column(name = "COUNTRY_CODE", length = 10, nullable = false)
	private String countryCode;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "BASIC_ID", referencedColumnName = "ID")
    private BasicDetailsEntity basicDetail;
	
}
