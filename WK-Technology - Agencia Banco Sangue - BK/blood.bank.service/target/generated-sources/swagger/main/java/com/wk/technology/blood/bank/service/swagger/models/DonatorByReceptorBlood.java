package com.wk.technology.blood.bank.service.swagger.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * DonatorByReceptorBlood
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-07-11T22:34:20.943-03:00")

public class DonatorByReceptorBlood   {
  @JsonProperty("receptorBloodType")
  private String receptorBloodType = null;

  @JsonProperty("quantity")
  private Integer quantity = null;

  public DonatorByReceptorBlood receptorBloodType(String receptorBloodType) {
    this.receptorBloodType = receptorBloodType;
    return this;
  }

  /**
   * Get receptorBloodType
   * @return receptorBloodType
  **/
  @ApiModelProperty(value = "")


  public String getReceptorBloodType() {
    return receptorBloodType;
  }

  public void setReceptorBloodType(String receptorBloodType) {
    this.receptorBloodType = receptorBloodType;
  }

  public DonatorByReceptorBlood quantity(Integer quantity) {
    this.quantity = quantity;
    return this;
  }

  /**
   * Get quantity
   * @return quantity
  **/
  @ApiModelProperty(value = "")


  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DonatorByReceptorBlood donatorByReceptorBlood = (DonatorByReceptorBlood) o;
    return Objects.equals(this.receptorBloodType, donatorByReceptorBlood.receptorBloodType) &&
        Objects.equals(this.quantity, donatorByReceptorBlood.quantity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(receptorBloodType, quantity);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DonatorByReceptorBlood {\n");
    
    sb.append("    receptorBloodType: ").append(toIndentedString(receptorBloodType)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
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

