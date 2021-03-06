package com.wk.technology.blood.bank.service.models.locations;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wk.technology.blood.bank.service.models.donators.Donator;
import com.wk.technology.blood.bank.service.swagger.models.DonatorDTO;

@Entity
@Table(name = "TB_ADDRESS")
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String address;
	private Integer number;
	private String district;
	private String zip;

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "donatorAddress")
	private Donator donator;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "city_id")
	private City city;

	public Address() {
	}

	public Address(Integer id, String address, Integer number, String district, String zip, City city, Donator donator) {
		super();
		this.id = id;
		this.address = address;
		this.number = number;
		this.district = district;
		this.zip = zip;
		this.setCity(city);
		this.setDonator(donator);
	}
	
	public static Address fromDonatorDto(DonatorDTO donatorDto) {
		Address address = new Address();
		address.setAddress(donatorDto.getEndereco());
		address.setNumber(donatorDto.getNumero());
		address.setDistrict(donatorDto.getBairro());
		address.setZip(donatorDto.getCep());
		
		State state = new State();
		state.setName(donatorDto.getEstado());
		City city = new City();
		city.setName(donatorDto.getCidade());
		city.setState(state);
		
		address.setCity(city);
		return address;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Donator getDonator() {
		return donator;
	}

	public void setDonator(Donator donator) {
		this.donator = donator;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", address=" + address + ", number=" + number + ", district=" + district + ", zip="
				+ zip + ", city=" + city + "]";
	}
	
	

}