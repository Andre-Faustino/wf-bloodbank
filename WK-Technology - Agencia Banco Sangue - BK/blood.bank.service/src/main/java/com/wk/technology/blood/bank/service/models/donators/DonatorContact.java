package com.wk.technology.blood.bank.service.models.donators;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wk.technology.blood.bank.service.models.enums.BloodType;
import com.wk.technology.blood.bank.service.swagger.models.DonatorDTO;

@Entity
@Table(name = "TB_DONATOR_CONTACT")
public class DonatorContact implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long donatorContactId;
	
	private String email;
	private String landline;
	private String phone;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "donatorContact")
	private Donator donator;
	
	public DonatorContact() {}

	public DonatorContact(Long donatorContactId, String email, String landline, String phone, Donator donator) {
		super();
		this.donatorContactId = donatorContactId;
		this.email = email;
		this.landline = landline;
		this.phone = phone;
		this.donator = donator;
	}
	
	public static DonatorContact fromDonatorDto(DonatorDTO donatorDto) {
		DonatorContact donatorContact = new DonatorContact();
		donatorContact.setEmail(donatorDto.getEmail());
		donatorContact.setLandline(donatorDto.getTelefoneFixo());
		donatorContact.setPhone(donatorDto.getCelular());		
		return donatorContact;
	}

	public Long getDonatorContactId() {
		return donatorContactId;
	}

	public void setDonatorContactId(Long donatorContactId) {
		this.donatorContactId = donatorContactId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLandline() {
		return landline;
	}

	public void setLandline(String landline) {
		this.landline = landline;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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
		result = prime * result + ((donator == null) ? 0 : donator.hashCode());
		result = prime * result + ((donatorContactId == null) ? 0 : donatorContactId.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((landline == null) ? 0 : landline.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
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
		DonatorContact other = (DonatorContact) obj;
		if (donator == null) {
			if (other.donator != null)
				return false;
		} else if (!donator.equals(other.donator))
			return false;
		if (donatorContactId == null) {
			if (other.donatorContactId != null)
				return false;
		} else if (!donatorContactId.equals(other.donatorContactId))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (landline == null) {
			if (other.landline != null)
				return false;
		} else if (!landline.equals(other.landline))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DonatorContact [donatorContactId=" + donatorContactId + ", email=" + email + ", landline=" + landline
				+ ", phone=" + phone + "]";
	}
	
	

}
