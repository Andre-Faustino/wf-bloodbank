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
 * AvgAgeByBlood
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-07-11T22:34:20.943-03:00")

public class AvgAgeByBlood   {
  @JsonProperty("bloodType")
  private String bloodType = null;

  @JsonProperty("age")
  private BigDecimal age = null;

  public AvgAgeByBlood bloodType(String bloodType) {
    this.bloodType = bloodType;
    return this;
  }

  /**
   * Get bloodType
   * @return bloodType
  **/
  @ApiModelProperty(value = "")


  public String getBloodType() {
    return bloodType;
  }

  public void setBloodType(String bloodType) {
    this.bloodType = bloodType;
  }

  public AvgAgeByBlood age(BigDecimal age) {
    this.age = age;
    return this;
  }

  /**
   * Get age
   * @return age
  **/
  @ApiModelProperty(value = "")

  @Valid

  public BigDecimal getAge() {
    return age;
  }

  public void setAge(BigDecimal age) {
    this.age = age;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AvgAgeByBlood avgAgeByBlood = (AvgAgeByBlood) o;
    return Objects.equals(this.bloodType, avgAgeByBlood.bloodType) &&
        Objects.equals(this.age, avgAgeByBlood.age);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bloodType, age);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AvgAgeByBlood {\n");
    
    sb.append("    bloodType: ").append(toIndentedString(bloodType)).append("\n");
    sb.append("    age: ").append(toIndentedString(age)).append("\n");
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

