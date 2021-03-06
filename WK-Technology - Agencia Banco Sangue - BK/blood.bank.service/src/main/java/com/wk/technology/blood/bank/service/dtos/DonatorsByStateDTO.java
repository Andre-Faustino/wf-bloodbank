package com.wk.technology.blood.bank.service.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wk.technology.blood.bank.service.swagger.models.DonatorsByState;

public class DonatorsByStateDTO {

	private String state;

	private Long amount;

	public DonatorsByStateDTO(String state, Long amount) {
		super();
		this.state = state;
		this.amount = amount;
	}
	
	public DonatorsByState DonatorsByStateBuilder() {
		DonatorsByState obj = new DonatorsByState();
		obj.setAmount(this.getAmount().intValue());
		obj.setState((this.getState()));
		return obj;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "DonatorsByStateDTO [state=" + state + ", amount=" + amount + "]";
	}
	
	
	

}
