package com.wk.technology.blood.bank.service.models.donators;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.wk.technology.blood.bank.service.models.enums.GenderType;
import com.wk.technology.blood.bank.service.models.locations.Address;
import com.wk.technology.blood.bank.service.swagger.models.DonatorDTO;

@Entity
@Table(name = "TB_DONATOR")
public class Donator implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long donatorId;

	private String donatorName;

	
	private String donatorCpf;
	private String donatorRg;
	private String donatorBirthdate;

	@Enumerated(EnumType.STRING)
	private GenderType donatorGender;
	private String donatorMother;
	private String donatorFather;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "contact_id")
	private DonatorContact donatorContact;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "info_id")	
	private DonatorInfo donatorInfo;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address donatorAddress;

	public Donator() {
	}

	public Donator(Long donatorId, String donatorName, String donatorCpf, String donatorRg, String donatorBirthdate,
			GenderType donatorGender, String donatorMother, String donatorFather, DonatorContact donatorContact,
			DonatorInfo donatorInfo, Address donatorAddress) {
		super();
		this.donatorId = donatorId;
		this.donatorName = donatorName;
		this.donatorCpf = donatorCpf;
		this.donatorRg = donatorRg;
		this.donatorBirthdate = donatorBirthdate;
		this.donatorGender = donatorGender;
		this.donatorMother = donatorMother;
		this.donatorFather = donatorFather;
		this.donatorContact = donatorContact;
		this.donatorInfo = donatorInfo;
		this.donatorAddress = donatorAddress;
	}
	
	public static Donator fromDonatorDto(DonatorDTO donatorDto) {
		Donator donator = new Donator();
		donator.setDonatorName(donatorDto.getNome());
		donator.setDonatorCpf(donatorDto.getCpf());
		donator.setDonatorRg(donatorDto.getRg());
		donator.setDonatorBirthdate(donatorDto.getDataNasc());
		donator.setDonatorGender(GenderType.decode(donatorDto.getSexo().toString()));
		donator.setDonatorFather(donatorDto.getPai());
		donator.setDonatorMother(donatorDto.getMae());
		return donator;
	}

	public Long getDonatorId() {
		return donatorId;
	}

	public void setDonatorId(Long donatorId) {
		this.donatorId = donatorId;
	}

	public String getDonatorName() {
		return donatorName;
	}

	public void setDonatorName(String donatorName) {
		this.donatorName = donatorName;
	}

	public String getDonatorCpf() {
		return donatorCpf;
	}

	public void setDonatorCpf(String donatorCpf) {
		this.donatorCpf = donatorCpf;
	}

	public String getDonatorRg() {
		return donatorRg;
	}

	public void setDonatorRg(String donatorRg) {
		this.donatorRg = donatorRg;
	}

	public String getDonatorBirthdate() {
		return donatorBirthdate;
	}

	public void setDonatorBirthdate(String donatorBirthdate) {
		this.donatorBirthdate = donatorBirthdate;
	}

	public GenderType getDonatorGender() {
		return donatorGender;
	}

	public void setDonatorGender(GenderType donatorGender) {
		this.donatorGender = donatorGender;
	}

	public String getDonatorMother() {
		return donatorMother;
	}

	public void setDonatorMother(String donatorMother) {
		this.donatorMother = donatorMother;
	}

	public String getDonatorFather() {
		return donatorFather;
	}

	public void setDonatorFather(String donatorFather) {
		this.donatorFather = donatorFather;
	}

	public DonatorContact getDonatorContact() {
		return donatorContact;
	}

	public void setDonatorContact(DonatorContact donatorContact) {
		this.donatorContact = donatorContact;
	}

	public DonatorInfo getDonatorInfo() {
		return donatorInfo;
	}

	public void setDonatorInfo(DonatorInfo donatorInfo) {
		this.donatorInfo = donatorInfo;
	}

	public Address getDonatorAddress() {
		return donatorAddress;
	}

	public void setDonatorAddress(Address donatorAddress) {
		this.donatorAddress = donatorAddress;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((donatorAddress == null) ? 0 : donatorAddress.hashCode());
		result = prime * result + ((donatorBirthdate == null) ? 0 : donatorBirthdate.hashCode());
		result = prime * result + ((donatorContact == null) ? 0 : donatorContact.hashCode());
		result = prime * result + ((donatorCpf == null) ? 0 : donatorCpf.hashCode());
		result = prime * result + ((donatorFather == null) ? 0 : donatorFather.hashCode());
		result = prime * result + ((donatorGender == null) ? 0 : donatorGender.hashCode());
		result = prime * result + ((donatorId == null) ? 0 : donatorId.hashCode());
		result = prime * result + ((donatorInfo == null) ? 0 : donatorInfo.hashCode());
		result = prime * result + ((donatorMother == null) ? 0 : donatorMother.hashCode());
		result = prime * result + ((donatorName == null) ? 0 : donatorName.hashCode());
		result = prime * result + ((donatorRg == null) ? 0 : donatorRg.hashCode());
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
		Donator other = (Donator) obj;
		if (donatorAddress == null) {
			if (other.donatorAddress != null)
				return false;
		} else if (!donatorAddress.equals(other.donatorAddress))
			return false;
		if (donatorBirthdate == null) {
			if (other.donatorBirthdate != null)
				return false;
		} else if (!donatorBirthdate.equals(other.donatorBirthdate))
			return false;
		if (donatorContact == null) {
			if (other.donatorContact != null)
				return false;
		} else if (!donatorContact.equals(other.donatorContact))
			return false;
		if (donatorCpf == null) {
			if (other.donatorCpf != null)
				return false;
		} else if (!donatorCpf.equals(other.donatorCpf))
			return false;
		if (donatorFather == null) {
			if (other.donatorFather != null)
				return false;
		} else if (!donatorFather.equals(other.donatorFather))
			return false;
		if (donatorGender != other.donatorGender)
			return false;
		if (donatorId == null) {
			if (other.donatorId != null)
				return false;
		} else if (!donatorId.equals(other.donatorId))
			return false;
		if (donatorInfo == null) {
			if (other.donatorInfo != null)
				return false;
		} else if (!donatorInfo.equals(other.donatorInfo))
			return false;
		if (donatorMother == null) {
			if (other.donatorMother != null)
				return false;
		} else if (!donatorMother.equals(other.donatorMother))
			return false;
		if (donatorName == null) {
			if (other.donatorName != null)
				return false;
		} else if (!donatorName.equals(other.donatorName))
			return false;
		if (donatorRg == null) {
			if (other.donatorRg != null)
				return false;
		} else if (!donatorRg.equals(other.donatorRg))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Donator [donatorId=" + donatorId + ", donatorName=" + donatorName + ", donatorCpf=" + donatorCpf
				+ ", donatorRg=" + donatorRg + ", donatorBirthdate=" + donatorBirthdate + ", donatorGender="
				+ donatorGender + ", donatorMother=" + donatorMother + ", donatorFather=" + donatorFather
				+ ", donatorContact=" + donatorContact + ", donatorInfo=" + donatorInfo + ", donatorAddress="
				+ donatorAddress + "]";
	}

}
