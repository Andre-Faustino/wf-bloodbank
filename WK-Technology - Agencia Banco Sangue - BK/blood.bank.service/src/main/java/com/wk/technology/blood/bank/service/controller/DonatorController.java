package com.wk.technology.blood.bank.service.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.wk.technology.blood.bank.service.models.donators.Donator;
import com.wk.technology.blood.bank.service.services.DonatorService;

import com.wk.technology.blood.bank.service.swagger.DonatorApi;
import com.wk.technology.blood.bank.service.swagger.models.AvgAgeByBlood;
import com.wk.technology.blood.bank.service.swagger.models.AvgIMCByAge;
import com.wk.technology.blood.bank.service.swagger.models.DonatorByReceptorBlood;
import com.wk.technology.blood.bank.service.swagger.models.DonatorDTO;
import com.wk.technology.blood.bank.service.swagger.models.DonatorDTOlist;
import com.wk.technology.blood.bank.service.swagger.models.DonatorsByState;
import com.wk.technology.blood.bank.service.swagger.models.GenderOverweight;
import com.wk.technology.blood.bank.service.swagger.models.ResponseMessage;

@RestController
public class DonatorController implements DonatorApi {

	private final Logger logger = LoggerFactory.getLogger(DonatorController.class);

	@Autowired
	private DonatorService donatorService;

	@Override
	public ResponseEntity<ResponseMessage> addDonator(@Valid DonatorDTO body) {
		logger.info("Start method addDonator");
		Donator obj = donatorService.saveDonator(body);
		
		
		logger.info("Finish method addDonator");
		return ResponseEntity.noContent().build();
	}

	@Override
	public ResponseEntity<List<DonatorsByState>> donatorsByState(@Valid String name) {

		List<DonatorsByState> response = donatorService.donatorByState(name);

		return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<List<AvgIMCByAge>> avgIMCByAgeRange(@Valid String rangeAge) {
		List<AvgIMCByAge> response = donatorService.averageIMCByAge(rangeAge); 
		return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<List<GenderOverweight>> avgOverweightByGenders() {
		List<GenderOverweight> response = donatorService.avgOverweightByGenders(); 
		return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<List<AvgAgeByBlood>> avgAgeByBlood(@Valid String blood) {
		List<AvgAgeByBlood> response = donatorService.avgAgeByBlood(blood); 
		return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<List<DonatorByReceptorBlood>> donatorsAmountByReceptorBlood(@Valid String blood) {
		List<DonatorByReceptorBlood> response = donatorService.donatorsAmountByReceptorBlood(blood); 
		return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<ResponseMessage> addDonatorList(@Valid DonatorDTOlist body) {
		logger.info("Start method addManyDonator");
		ResponseMessage response = donatorService.saveManyDonator(body);
		logger.info("Finish method addManyDonator");
		return ResponseEntity.ok(response);
	}

	
	
}
