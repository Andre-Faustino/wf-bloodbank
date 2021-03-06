package com.wk.technology.blood.bank.service.swagger.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * GenderOverweight
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-07-11T22:34:20.943-03:00")

public class GenderOverweight   {
  @JsonProperty("gender")
  private String gender = null;

  @JsonProperty("percentual")
  private BigDecimal percentual = null;

  public GenderOverweight gender(String gender) {
    this.gender = gender;
    return this;
  }

  /**
   * Get gender
   * @return gender
  **/
  @ApiModelProperty(value = "")


  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public GenderOverweight percentual(BigDecimal percentual) {
    this.percentual = percentual;
    return this;
  }

  /**
   * Get percentual
   * @return percentual
  **/
  @ApiModelProperty(value = "")

  @Valid

  public BigDecimal getPercentual() {
    return percentual;
  }

  public void setPercentual(BigDecimal percentual) {
    this.percentual = percentual;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GenderOverweight genderOverweight = (GenderOverweight) o;
    return Objects.equals(this.gender, genderOverweight.gender) &&
        Objects.equals(this.percentual, genderOverweight.percentual);
  }

  @Override
  public int hashCode() {
    return Objects.hash(gender, percentual);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GenderOverweight {\n");
    
    sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
    sb.append("    percentual: ").append(toIndentedString(percentual)).append("\n");
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

