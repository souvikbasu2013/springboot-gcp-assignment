package com.gcp.assignment.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Party
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-01-27T21:22:55.769806700+05:30[Asia/Calcutta]")


public class Party   {
  @JsonProperty("partyId")
  private Long partyId = null;

  @JsonProperty("partyNumber")
  private String partyNumber = null;

  /**
   * Gets or Sets partyType
   */
  public enum PartyTypeEnum {
    NATURAL_PERSON("Natural Person"),
    
    LEGAL_ENTITY("Legal Entity");

    private String value;

    PartyTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static PartyTypeEnum fromValue(String text) {
      for (PartyTypeEnum b : PartyTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("partyType")
  private PartyTypeEnum partyType = null;

  @JsonProperty("createdBy")
  private String createdBy = null;

  @JsonProperty("createdDate")
  private String createdDate = null;

  @JsonProperty("updatedBy")
  private String updatedBy = null;

  @JsonProperty("updatedDate")
  private String updatedDate = null;

  public Party partyId(Long partyId) {
    this.partyId = partyId;
    return this;
  }

  /**
   * Get partyId
   * @return partyId
   **/
  @Schema(example = "123", description = "")
  
    public Long getPartyId() {
    return partyId;
  }

  public void setPartyId(Long partyId) {
    this.partyId = partyId;
  }

  public Party partyNumber(String partyNumber) {
    this.partyNumber = partyNumber;
    return this;
  }

  /**
   * Get partyNumber
   * @return partyNumber
   **/
  @Schema(example = "C000123", description = "")
  
    public String getPartyNumber() {
    return partyNumber;
  }

  public void setPartyNumber(String partyNumber) {
    this.partyNumber = partyNumber;
  }

  public Party partyType(PartyTypeEnum partyType) {
    this.partyType = partyType;
    return this;
  }

  /**
   * Get partyType
   * @return partyType
   **/
  @Schema(description = "")
  
    public PartyTypeEnum getPartyType() {
    return partyType;
  }

  public void setPartyType(PartyTypeEnum partyType) {
    this.partyType = partyType;
  }

  public Party createdBy(String createdBy) {
    this.createdBy = createdBy;
    return this;
  }

  /**
   * Get createdBy
   * @return createdBy
   **/
  @Schema(example = "John Doe", description = "")
  
    public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public Party createdDate(String createdDate) {
    this.createdDate = createdDate;
    return this;
  }

  /**
   * Get createdDate
   * @return createdDate
   **/
  @Schema(example = "2023-12-15", description = "")
  
    public String getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(String createdDate) {
    this.createdDate = createdDate;
  }

  public Party updatedBy(String updatedBy) {
    this.updatedBy = updatedBy;
    return this;
  }

  /**
   * Get updatedBy
   * @return updatedBy
   **/
  @Schema(example = "John Doe", description = "")
  
    public String getUpdatedBy() {
    return updatedBy;
  }

  public void setUpdatedBy(String updatedBy) {
    this.updatedBy = updatedBy;
  }

  public Party updatedDate(String updatedDate) {
    this.updatedDate = updatedDate;
    return this;
  }

  /**
   * Get updatedDate
   * @return updatedDate
   **/
  @Schema(example = "2023-12-15", description = "")
  
    public String getUpdatedDate() {
    return updatedDate;
  }

  public void setUpdatedDate(String updatedDate) {
    this.updatedDate = updatedDate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Party party = (Party) o;
    return Objects.equals(this.partyId, party.partyId) &&
        Objects.equals(this.partyNumber, party.partyNumber) &&
        Objects.equals(this.partyType, party.partyType) &&
        Objects.equals(this.createdBy, party.createdBy) &&
        Objects.equals(this.createdDate, party.createdDate) &&
        Objects.equals(this.updatedBy, party.updatedBy) &&
        Objects.equals(this.updatedDate, party.updatedDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(partyId, partyNumber, partyType, createdBy, createdDate, updatedBy, updatedDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Party {\n");
    
    sb.append("    partyId: ").append(toIndentedString(partyId)).append("\n");
    sb.append("    partyNumber: ").append(toIndentedString(partyNumber)).append("\n");
    sb.append("    partyType: ").append(toIndentedString(partyType)).append("\n");
    sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
    sb.append("    createdDate: ").append(toIndentedString(createdDate)).append("\n");
    sb.append("    updatedBy: ").append(toIndentedString(updatedBy)).append("\n");
    sb.append("    updatedDate: ").append(toIndentedString(updatedDate)).append("\n");
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
