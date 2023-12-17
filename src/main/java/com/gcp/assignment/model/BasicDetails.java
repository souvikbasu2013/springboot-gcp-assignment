package com.gcp.assignment.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * BasicDetails
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-12-18T00:24:05.308992+05:30[Asia/Calcutta]")


public class BasicDetails   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("partnerKey")
  private String partnerKey = null;

  @JsonProperty("firstName")
  private String firstName = null;

  @JsonProperty("lastName")
  private String lastName = null;

  @JsonProperty("age")
  private Long age = null;

  @JsonProperty("dob")
  private String dob = null;

  public BasicDetails id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   **/
  @Schema(example = "111", description = "")
  
    public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public BasicDetails partnerKey(String partnerKey) {
    this.partnerKey = partnerKey;
    return this;
  }

  /**
   * Get partnerKey
   * @return partnerKey
   **/
  @Schema(example = "KEY123", required = true, description = "")
      @NotNull

    public String getPartnerKey() {
    return partnerKey;
  }

  public void setPartnerKey(String partnerKey) {
    this.partnerKey = partnerKey;
  }

  public BasicDetails firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * Get firstName
   * @return firstName
   **/
  @Schema(example = "Souvik", required = true, description = "")
      @NotNull

    public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public BasicDetails lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Get lastName
   * @return lastName
   **/
  @Schema(example = "Basu", required = true, description = "")
      @NotNull

    public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public BasicDetails age(Long age) {
    this.age = age;
    return this;
  }

  /**
   * Get age
   * @return age
   **/
  @Schema(example = "10", required = true, description = "")
      @NotNull

    public Long getAge() {
    return age;
  }

  public void setAge(Long age) {
    this.age = age;
  }

  public BasicDetails dob(String dob) {
    this.dob = dob;
    return this;
  }

  /**
   * Get dob
   * @return dob
   **/
  @Schema(example = "2023-12-15", required = true, description = "")
      @NotNull

    public String getDob() {
    return dob;
  }

  public void setDob(String dob) {
    this.dob = dob;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BasicDetails basicDetails = (BasicDetails) o;
    return Objects.equals(this.id, basicDetails.id) &&
        Objects.equals(this.partnerKey, basicDetails.partnerKey) &&
        Objects.equals(this.firstName, basicDetails.firstName) &&
        Objects.equals(this.lastName, basicDetails.lastName) &&
        Objects.equals(this.age, basicDetails.age) &&
        Objects.equals(this.dob, basicDetails.dob);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, partnerKey, firstName, lastName, age, dob);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BasicDetails {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    partnerKey: ").append(toIndentedString(partnerKey)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    age: ").append(toIndentedString(age)).append("\n");
    sb.append("    dob: ").append(toIndentedString(dob)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
