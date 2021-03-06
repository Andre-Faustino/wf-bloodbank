package com.wk.technology.blood.bank.service.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import com.wk.technology.blood.bank.service.models.donators.Donator;

public class DonatorValidator {

	public static Boolean validateDonator(Donator donator) {

		Long age = getAge(donator.getDonatorBirthdate()); 
		Double weight = donator.getDonatorInfo().getDonatorWeight();
		
		return (age > 16 && age < 69 && weight > 50.) ? true : false;
	}
	
	public static Long getAge(String birthDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		String date = birthDate;
		LocalDate localDate = LocalDate.parse(date, formatter);
		return ChronoUnit.YEARS.between(localDate, LocalDate.now());
	}
	
	public static Double calcIMC(Donator donator) {
		 return donator.getDonatorInfo().getDonatorWeight()
			/ (donator.getDonatorInfo().getDonatorHeight() * donator.getDonatorInfo().getDonatorHeight());
	}
	
	public static Boolean verifyYear(Donator donator, Integer firstYear, Integer lastYear) {
		Long age = getAge(donator.getDonatorBirthdate());
		return (age >= firstYear && age <= lastYear) ? true : false;
	}
	
}
