package com.gcp.assignment.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.gcp.assignment.model.AddressState;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Address
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-01-27T21:22:55.769806700+05:30[Asia/Calcutta]")


public class Address   {
  @JsonProperty("addressId")
  private Integer addressId = null;

  /**
   * Gets or Sets addressType
   */
  public enum AddressTypeEnum {
    AUXILIARY_ADDRESS("Auxiliary Address"),
    
    PHYSICAL_ADDRESS("Physical Address"),
    
    WORK_ADDRESS("Work Address");

    private String value;

    AddressTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static AddressTypeEnum fromValue(String text) {
      for (AddressTypeEnum b : AddressTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("addressType")
  private AddressTypeEnum addressType = null;

  @JsonProperty("AddressStates")
  @Valid
  private List<AddressState> addressStates = null;

  public Address addressId(Integer addressId) {
    this.addressId = addressId;
    return this;
  }

  /**
   * Get addressId
   * @return addressId
   **/
  @Schema(example = "123", description = "")
  
    public Integer getAddressId() {
    return addressId;
  }

  public void setAddressId(Integer addressId) {
    this.addressId = addressId;
  }

  public Address addressType(AddressTypeEnum addressType) {
    this.addressType = addressType;
    return this;
  }

  /**
   * Get addressType
   * @return addressType
   **/
  @Schema(example = "Physical Address", description = "")
  
    public AddressTypeEnum getAddressType() {
    return addressType;
  }

  public void setAddressType(AddressTypeEnum addressType) {
    this.addressType = addressType;
  }

  public Address addressStates(List<AddressState> addressStates) {
    this.addressStates = addressStates;
    return this;
  }

  public Address addAddressStatesItem(AddressState addressStatesItem) {
    if (this.addressStates == null) {
      this.addressStates = new ArrayList<AddressState>();
    }
    this.addressStates.add(addressStatesItem);
    return this;
  }

  /**
   * Get addressStates
   * @return addressStates
   **/
  @Schema(description = "")
      @Valid
    public List<AddressState> getAddressStates() {
    return addressStates;
  }

  public void setAddressStates(List<AddressState> addressStates) {
    this.addressStates = addressStates;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Address address = (Address) o;
    return Objects.equals(this.addressId, address.addressId) &&
        Objects.equals(this.addressType, address.addressType) &&
        Objects.equals(this.addressStates, address.addressStates);
  }

  @Override
  public int hashCode() {
    return Objects.hash(addressId, addressType, addressStates);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Address {\n");
    
    sb.append("    addressId: ").append(toIndentedString(addressId)).append("\n");
    sb.append("    addressType: ").append(toIndentedString(addressType)).append("\n");
    sb.append("    addressStates: ").append(toIndentedString(addressStates)).append("\n");
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
