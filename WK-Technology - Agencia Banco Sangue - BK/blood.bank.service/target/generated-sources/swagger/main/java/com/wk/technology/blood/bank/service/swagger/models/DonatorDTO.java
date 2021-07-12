package com.wk.technology.blood.bank.service.swagger.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * DonatorDTO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-07-11T22:34:20.943-03:00")

public class DonatorDTO   {
  @JsonProperty("nome")
  private String nome = null;

  @JsonProperty("cpf")
  private String cpf = null;

  @JsonProperty("rg")
  private String rg = null;

  @JsonProperty("data_nasc")
  private String dataNasc = null;

  /**
   * Gets or Sets sexo
   */
  public enum SexoEnum {
    MASCULINO("Masculino"),
    
    FEMININO("Feminino");

    private String value;

    SexoEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static SexoEnum fromValue(String text) {
      for (SexoEnum b : SexoEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("sexo")
  private SexoEnum sexo = null;

  @JsonProperty("mae")
  private String mae = null;

  @JsonProperty("pai")
  private String pai = null;

  @JsonProperty("email")
  private String email = null;

  @JsonProperty("cep")
  private String cep = null;

  @JsonProperty("endereco")
  private String endereco = null;

  @JsonProperty("numero")
  private Integer numero = null;

  @JsonProperty("bairro")
  private String bairro = null;

  @JsonProperty("cidade")
  private String cidade = null;

  @JsonProperty("estado")
  private String estado = null;

  @JsonProperty("telefone_fixo")
  private String telefoneFixo = null;

  @JsonProperty("celular")
  private String celular = null;

  @JsonProperty("altura")
  private BigDecimal altura = null;

  @JsonProperty("peso")
  private BigDecimal peso = null;

  @JsonProperty("tipo_sanguineo")
  private String tipoSanguineo = null;

  public DonatorDTO nome(String nome) {
    this.nome = nome;
    return this;
  }

  /**
   * Get nome
   * @return nome
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public DonatorDTO cpf(String cpf) {
    this.cpf = cpf;
    return this;
  }

  /**
   * Get cpf
   * @return cpf
  **/
  @ApiModelProperty(value = "")


  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public DonatorDTO rg(String rg) {
    this.rg = rg;
    return this;
  }

  /**
   * Get rg
   * @return rg
  **/
  @ApiModelProperty(value = "")


  public String getRg() {
    return rg;
  }

  public void setRg(String rg) {
    this.rg = rg;
  }

  public DonatorDTO dataNasc(String dataNasc) {
    this.dataNasc = dataNasc;
    return this;
  }

  /**
   * Get dataNasc
   * @return dataNasc
  **/
  @ApiModelProperty(value = "")


  public String getDataNasc() {
    return dataNasc;
  }

  public void setDataNasc(String dataNasc) {
    this.dataNasc = dataNasc;
  }

  public DonatorDTO sexo(SexoEnum sexo) {
    this.sexo = sexo;
    return this;
  }

  /**
   * Get sexo
   * @return sexo
  **/
  @ApiModelProperty(value = "")


  public SexoEnum getSexo() {
    return sexo;
  }

  public void setSexo(SexoEnum sexo) {
    this.sexo = sexo;
  }

  public DonatorDTO mae(String mae) {
    this.mae = mae;
    return this;
  }

  /**
   * Get mae
   * @return mae
  **/
  @ApiModelProperty(value = "")


  public String getMae() {
    return mae;
  }

  public void setMae(String mae) {
    this.mae = mae;
  }

  public DonatorDTO pai(String pai) {
    this.pai = pai;
    return this;
  }

  /**
   * Get pai
   * @return pai
  **/
  @ApiModelProperty(value = "")


  public String getPai() {
    return pai;
  }

  public void setPai(String pai) {
    this.pai = pai;
  }

  public DonatorDTO email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
  **/
  @ApiModelProperty(value = "")


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public DonatorDTO cep(String cep) {
    this.cep = cep;
    return this;
  }

  /**
   * Get cep
   * @return cep
  **/
  @ApiModelProperty(value = "")


  public String getCep() {
    return cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }

  public DonatorDTO endereco(String endereco) {
    this.endereco = endereco;
    return this;
  }

  /**
   * Get endereco
   * @return endereco
  **/
  @ApiModelProperty(value = "")


  public String getEndereco() {
    return endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public DonatorDTO numero(Integer numero) {
    this.numero = numero;
    return this;
  }

  /**
   * Get numero
   * @return numero
  **/
  @ApiModelProperty(value = "")


  public Integer getNumero() {
    return numero;
  }

  public void setNumero(Integer numero) {
    this.numero = numero;
  }

  public DonatorDTO bairro(String bairro) {
    this.bairro = bairro;
    return this;
  }

  /**
   * Get bairro
   * @return bairro
  **/
  @ApiModelProperty(value = "")


  public String getBairro() {
    return bairro;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

  public DonatorDTO cidade(String cidade) {
    this.cidade = cidade;
    return this;
  }

  /**
   * Get cidade
   * @return cidade
  **/
  @ApiModelProperty(value = "")


  public String getCidade() {
    return cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public DonatorDTO estado(String estado) {
    this.estado = estado;
    return this;
  }

  /**
   * Get estado
   * @return estado
  **/
  @ApiModelProperty(value = "")


  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public DonatorDTO telefoneFixo(String telefoneFixo) {
    this.telefoneFixo = telefoneFixo;
    return this;
  }

  /**
   * Get telefoneFixo
   * @return telefoneFixo
  **/
  @ApiModelProperty(value = "")


  public String getTelefoneFixo() {
    return telefoneFixo;
  }

  public void setTelefoneFixo(String telefoneFixo) {
    this.telefoneFixo = telefoneFixo;
  }

  public DonatorDTO celular(String celular) {
    this.celular = celular;
    return this;
  }

  /**
   * Get celular
   * @return celular
  **/
  @ApiModelProperty(value = "")


  public String getCelular() {
    return celular;
  }

  public void setCelular(String celular) {
    this.celular = celular;
  }

  public DonatorDTO altura(BigDecimal altura) {
    this.altura = altura;
    return this;
  }

  /**
   * Get altura
   * @return altura
  **/
  @ApiModelProperty(value = "")

  @Valid

  public BigDecimal getAltura() {
    return altura;
  }

  public void setAltura(BigDecimal altura) {
    this.altura = altura;
  }

  public DonatorDTO peso(BigDecimal peso) {
    this.peso = peso;
    return this;
  }

  /**
   * Get peso
   * @return peso
  **/
  @ApiModelProperty(value = "")

  @Valid

  public BigDecimal getPeso() {
    return peso;
  }

  public void setPeso(BigDecimal peso) {
    this.peso = peso;
  }

  public DonatorDTO tipoSanguineo(String tipoSanguineo) {
    this.tipoSanguineo = tipoSanguineo;
    return this;
  }

  /**
   * Get tipoSanguineo
   * @return tipoSanguineo
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getTipoSanguineo() {
    return tipoSanguineo;
  }

  public void setTipoSanguineo(String tipoSanguineo) {
    this.tipoSanguineo = tipoSanguineo;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DonatorDTO donatorDTO = (DonatorDTO) o;
    return Objects.equals(this.nome, donatorDTO.nome) &&
        Objects.equals(this.cpf, donatorDTO.cpf) &&
        Objects.equals(this.rg, donatorDTO.rg) &&
        Objects.equals(this.dataNasc, donatorDTO.dataNasc) &&
        Objects.equals(this.sexo, donatorDTO.sexo) &&
        Objects.equals(this.mae, donatorDTO.mae) &&
        Objects.equals(this.pai, donatorDTO.pai) &&
        Objects.equals(this.email, donatorDTO.email) &&
        Objects.equals(this.cep, donatorDTO.cep) &&
        Objects.equals(this.endereco, donatorDTO.endereco) &&
        Objects.equals(this.numero, donatorDTO.numero) &&
        Objects.equals(this.bairro, donatorDTO.bairro) &&
        Objects.equals(this.cidade, donatorDTO.cidade) &&
        Objects.equals(this.estado, donatorDTO.estado) &&
        Objects.equals(this.telefoneFixo, donatorDTO.telefoneFixo) &&
        Objects.equals(this.celular, donatorDTO.celular) &&
        Objects.equals(this.altura, donatorDTO.altura) &&
        Objects.equals(this.peso, donatorDTO.peso) &&
        Objects.equals(this.tipoSanguineo, donatorDTO.tipoSanguineo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nome, cpf, rg, dataNasc, sexo, mae, pai, email, cep, endereco, numero, bairro, cidade, estado, telefoneFixo, celular, altura, peso, tipoSanguineo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DonatorDTO {\n");
    
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    cpf: ").append(toIndentedString(cpf)).append("\n");
    sb.append("    rg: ").append(toIndentedString(rg)).append("\n");
    sb.append("    dataNasc: ").append(toIndentedString(dataNasc)).append("\n");
    sb.append("    sexo: ").append(toIndentedString(sexo)).append("\n");
    sb.append("    mae: ").append(toIndentedString(mae)).append("\n");
    sb.append("    pai: ").append(toIndentedString(pai)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    cep: ").append(toIndentedString(cep)).append("\n");
    sb.append("    endereco: ").append(toIndentedString(endereco)).append("\n");
    sb.append("    numero: ").append(toIndentedString(numero)).append("\n");
    sb.append("    bairro: ").append(toIndentedString(bairro)).append("\n");
    sb.append("    cidade: ").append(toIndentedString(cidade)).append("\n");
    sb.append("    estado: ").append(toIndentedString(estado)).append("\n");
    sb.append("    telefoneFixo: ").append(toIndentedString(telefoneFixo)).append("\n");
    sb.append("    celular: ").append(toIndentedString(celular)).append("\n");
    sb.append("    altura: ").append(toIndentedString(altura)).append("\n");
    sb.append("    peso: ").append(toIndentedString(peso)).append("\n");
    sb.append("    tipoSanguineo: ").append(toIndentedString(tipoSanguineo)).append("\n");
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

