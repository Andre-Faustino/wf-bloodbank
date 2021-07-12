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
 * AvgIMCByAge
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-07-11T22:34:20.943-03:00")

public class AvgIMCByAge   {
  @JsonProperty("ageRange")
  private String ageRange = null;

  @JsonProperty("imc")
  private BigDecimal imc = null;

  public AvgIMCByAge ageRange(String ageRange) {
    this.ageRange = ageRange;
    return this;
  }

  /**
   * Get ageRange
   * @return ageRange
  **/
  @ApiModelProperty(value = "")


  public String getAgeRange() {
    return ageRange;
  }

  public void setAgeRange(String ageRange) {
    this.ageRange = ageRange;
  }

  public AvgIMCByAge imc(BigDecimal imc) {
    this.imc = imc;
    return this;
  }

  /**
   * Get imc
   * @return imc
  **/
  @ApiModelProperty(value = "")

  @Valid

  public BigDecimal getImc() {
    return imc;
  }

  public void setImc(BigDecimal imc) {
    this.imc = imc;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AvgIMCByAge avgIMCByAge = (AvgIMCByAge) o;
    return Objects.equals(this.ageRange, avgIMCByAge.ageRange) &&
        Objects.equals(this.imc, avgIMCByAge.imc);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ageRange, imc);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AvgIMCByAge {\n");
    
    sb.append("    ageRange: ").append(toIndentedString(ageRange)).append("\n");
    sb.append("    imc: ").append(toIndentedString(imc)).append("\n");
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

