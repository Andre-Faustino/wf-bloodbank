package com.wk.technology.blood.bank.service.models.enums;

import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum GenderType {
	
	M ("Masculino"),
	F ("Feminino");
	
	private String code;
	
	private GenderType(String code) {
		this.code=code;
	}
	
	@JsonCreator
	public static GenderType decode(final String code) {
		return Stream.of(GenderType.values()).filter(targetEnum -> targetEnum.code.equals(code)).findFirst().orElse(null);
	}
	
	
	@JsonValue
	public String getCode() {
		return code;
	}

}
