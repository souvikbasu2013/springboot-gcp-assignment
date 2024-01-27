package com.gcp.assignment.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AddressState
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-01-27T21:22:55.769806700+05:30[Asia/Calcutta]")


public class AddressState   {
  @JsonProperty("streetName")
  private String streetName = null;

  @JsonProperty("pobox")
  private String pobox = null;

  @JsonProperty("countryCode")
  private String countryCode = null;

  public AddressState streetName(String streetName) {
    this.streetName = streetName;
    return this;
  }

  /**
   * Get streetName
   * @return streetName
   **/
  @Schema(example = "1 wonton street", description = "")
  
    public String getStreetName() {
    return streetName;
  }

  public void setStreetName(String streetName) {
    this.streetName = streetName;
  }

  public AddressState pobox(String pobox) {
    this.pobox = pobox;
    return this;
  }

  /**
   * Get pobox
   * @return pobox
   **/
  @Schema(example = "201243", description = "")
  
    public String getPobox() {
    return pobox;
  }

  public void setPobox(String pobox) {
    this.pobox = pobox;
  }

  public AddressState countryCode(String countryCode) {
    this.countryCode = countryCode;
    return this;
  }

  /**
   * Get countryCode
   * @return countryCode
   **/
  @Schema(example = "IND", description = "")
  
    public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AddressState addressState = (AddressState) o;
    return Objects.equals(this.streetName, addressState.streetName) &&
        Objects.equals(this.pobox, addressState.pobox) &&
        Objects.equals(this.countryCode, addressState.countryCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(streetName, pobox, countryCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AddressState {\n");
    
    sb.append("    streetName: ").append(toIndentedString(streetName)).append("\n");
    sb.append("    pobox: ").append(toIndentedString(pobox)).append("\n");
    sb.append("    countryCode: ").append(toIndentedString(countryCode)).append("\n");
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
