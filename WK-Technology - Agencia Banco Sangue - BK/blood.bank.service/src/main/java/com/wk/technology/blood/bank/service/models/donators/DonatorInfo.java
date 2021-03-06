package com.wk.technology.blood.bank.service.models.donators;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wk.technology.blood.bank.service.models.enums.BloodType;
import com.wk.technology.blood.bank.service.swagger.models.DonatorDTO;

@Entity
@Table(name = "TB_DONATOR_INFO")
public class DonatorInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long donatorInfoId;

	private Double donatorHeight;
	private Double donatorWeight;
	
	@Enumerated(EnumType.STRING)
	private BloodType donatorBloodType;

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "donatorInfo")
	private Donator donator;

	public DonatorInfo() {
	}

	public DonatorInfo(Long donatorInfoId, Double donatorHeight, Double donatorWeight, BloodType donatorBloodType,
			Donator donator) {
		super();
		this.donatorInfoId = donatorInfoId;
		this.donatorHeight = donatorHeight;
		this.donatorWeight = donatorWeight;
		this.donatorBloodType = donatorBloodType;
		this.donator = donator;
	}
	
	public static DonatorInfo fromDonatorDto(DonatorDTO donatorDto) {
		DonatorInfo donatorInfo = new DonatorInfo();
		donatorInfo.setDonatorHeight(donatorDto.getAltura().doubleValue());
		donatorInfo.setDonatorWeight(donatorDto.getPeso().doubleValue());
		donatorInfo.setDonatorBloodType(BloodType.decode(donatorDto.getTipoSanguineo()));
		return donatorInfo;
	}

	public Long getDonatorInfoId() {
		return donatorInfoId;
	}

	public void setDonatorInfoId(Long donatorInfoId) {
		this.donatorInfoId = donatorInfoId;
	}

	public Double getDonatorHeight() {
		return donatorHeight;
	}

	public void setDonatorHeight(Double donatorHeight) {
		this.donatorHeight = donatorHeight;
	}

	public Double getDonatorWeight() {
		return donatorWeight;
	}

	public void setDonatorWeight(Double donatorWeight) {
		this.donatorWeight = donatorWeight;
	}

	public BloodType getDonatorBloodType() {
		return donatorBloodType;
	}

	public void setDonatorBloodType(BloodType donatorBloodType) {
		this.donatorBloodType = donatorBloodType;
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
		result = prime * result + ((donatorBloodType == null) ? 0 : donatorBloodType.hashCode());
		result = prime * result + ((donatorHeight == null) ? 0 : donatorHeight.hashCode());
		result = prime * result + ((donatorInfoId == null) ? 0 : donatorInfoId.hashCode());
		result = prime * result + ((donatorWeight == null) ? 0 : donatorWeight.hashCode());
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
		DonatorInfo other = (DonatorInfo) obj;
		if (donator == null) {
			if (other.donator != null)
				return false;
		} else if (!donator.equals(other.donator))
			return false;
		if (donatorBloodType != other.donatorBloodType)
			return false;
		if (donatorHeight == null) {
			if (other.donatorHeight != null)
				return false;
		} else if (!donatorHeight.equals(other.donatorHeight))
			return false;
		if (donatorInfoId == null) {
			if (other.donatorInfoId != null)
				return false;
		} else if (!donatorInfoId.equals(other.donatorInfoId))
			return false;
		if (donatorWeight == null) {
			if (other.donatorWeight != null)
				return false;
		} else if (!donatorWeight.equals(other.donatorWeight))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DonatorInfo [donatorInfoId=" + donatorInfoId + ", donatorHeight=" + donatorHeight + ", donatorWeight="
				+ donatorWeight + ", donatorBloodType=" + donatorBloodType + "]";
	}

}
