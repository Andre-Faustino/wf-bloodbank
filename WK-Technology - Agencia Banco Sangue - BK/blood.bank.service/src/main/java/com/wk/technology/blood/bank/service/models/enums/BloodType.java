package com.wk.technology.blood.bank.service.models.enums;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum BloodType {
	
	A_PLUS("A+"),
	A_MINUS("A-"),
	B_PLUS("B+"),
	B_MINUS("B-"),
	AB_PLUS("AB+"),
	AB_MINUS("AB-"),
	O_PLUS("O+"),
	O_MINUS("O-");
	
	
	private String code;
	
	private BloodType(String code) {
		this.code=code;
	}
	
	@JsonCreator
	public static BloodType decode(final String code) {
		return Stream.of(BloodType.values()).filter(targetEnum -> targetEnum.code.equals(code)).findFirst().orElse(null);
	}
	
	@JsonValue
	public String getCode() {
		return code;
	}
	
	public static final Map<BloodType, List<BloodType>> receiverDonatorMap = new HashMap<>() {
		private static final long serialVersionUID = 1L;

	{
		put(BloodType.A_PLUS, Arrays.asList(BloodType.A_PLUS, BloodType.A_MINUS, BloodType.O_PLUS, BloodType.O_MINUS));
		put(BloodType.A_MINUS, Arrays.asList(BloodType.A_MINUS, BloodType.O_MINUS));
		put(BloodType.B_PLUS, Arrays.asList(BloodType.B_PLUS, BloodType.B_MINUS, BloodType.O_PLUS, BloodType.O_MINUS));
		put(BloodType.B_MINUS, Arrays.asList(BloodType.B_MINUS, BloodType.O_MINUS));
		put(BloodType.AB_PLUS, Arrays.asList(BloodType.AB_PLUS, BloodType.AB_MINUS, BloodType.A_PLUS, BloodType.A_MINUS, BloodType.B_PLUS, BloodType.B_MINUS, BloodType.O_PLUS, BloodType.O_MINUS));
		put(BloodType.AB_MINUS, Arrays.asList(BloodType.AB_MINUS, BloodType.A_MINUS, BloodType.B_MINUS, BloodType.O_MINUS));
		put(BloodType.O_PLUS, Arrays.asList(BloodType.O_PLUS, BloodType.O_MINUS));
		put(BloodType.O_MINUS, Arrays.asList(BloodType.O_MINUS));
	}};

}
