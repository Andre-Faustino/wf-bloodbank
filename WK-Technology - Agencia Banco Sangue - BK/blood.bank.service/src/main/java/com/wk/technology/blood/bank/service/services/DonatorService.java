package com.wk.technology.blood.bank.service.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wk.technology.blood.bank.service.dtos.DonatorsByStateDTO;
import com.wk.technology.blood.bank.service.models.donators.Donator;
import com.wk.technology.blood.bank.service.models.donators.DonatorContact;
import com.wk.technology.blood.bank.service.models.donators.DonatorInfo;
import com.wk.technology.blood.bank.service.models.enums.BloodType;
import com.wk.technology.blood.bank.service.models.enums.GenderType;
import com.wk.technology.blood.bank.service.models.locations.Address;
import com.wk.technology.blood.bank.service.models.locations.City;
import com.wk.technology.blood.bank.service.models.locations.State;
import com.wk.technology.blood.bank.service.repositories.CityRepository;
import com.wk.technology.blood.bank.service.repositories.DonatorRepository;
import com.wk.technology.blood.bank.service.repositories.StateRepository;
import com.wk.technology.blood.bank.service.swagger.models.AvgAgeByBlood;
import com.wk.technology.blood.bank.service.swagger.models.AvgIMCByAge;
import com.wk.technology.blood.bank.service.swagger.models.DonatorByReceptorBlood;
import com.wk.technology.blood.bank.service.swagger.models.DonatorDTO;
import com.wk.technology.blood.bank.service.swagger.models.DonatorDTOlist;
import com.wk.technology.blood.bank.service.swagger.models.DonatorsByState;
import com.wk.technology.blood.bank.service.swagger.models.GenderOverweight;
import com.wk.technology.blood.bank.service.swagger.models.ResponseMessage;
import com.wk.technology.blood.bank.service.utils.DonatorValidator;

@Service
public class DonatorService {

	private final Logger logger = LoggerFactory.getLogger(DonatorService.class);

	@Autowired
	private DonatorRepository donatorRepo;

	@Autowired
	private CityRepository cityRepo;

	@Autowired
	private StateRepository stateRepo;

	public Donator saveDonator(DonatorDTO donatorDto) {
		logger.info("Start method saveDonator");

		DonatorInfo donatorInfo = DonatorInfo.fromDonatorDto(donatorDto);
		DonatorContact donatorContact = DonatorContact.fromDonatorDto(donatorDto);
		Address address = getValidAddress(donatorDto);

		Donator donator = Donator.fromDonatorDto(donatorDto);
		donator.setDonatorContact(donatorContact);
		donator.setDonatorInfo(donatorInfo);
		donator.setDonatorAddress(address);

		Donator obj = donatorRepo.save(donator);
		logger.info(obj.toString());

		logger.info("Finish method saveDonator");
		return obj;
	}

	public List<DonatorsByState> donatorByState(String name) {
		logger.info("Start method donatorByState");

		List<DonatorsByStateDTO> responseRepo = (name != null) ? donatorRepo.countDonatorsByState(name)
				: donatorRepo.countDonatorsByState();
		List<DonatorsByState> responseList = responseRepo.stream().map(item -> item.DonatorsByStateBuilder())
				.collect(Collectors.toList());

		logger.info("Finish method donatorByState");
		return responseList;
	}

	public List<AvgIMCByAge> averageIMCByAge(String rangeAge) {
		logger.info("Start method averageIMCByAge");
		Integer range = Integer.valueOf(rangeAge);

		List<Donator> donators = donatorRepo.findAll();

		Long limit = ((long) Math.ceil(100 / range)) + 1;
		List<Integer> rangeOfYears = IntStream.iterate(1, i -> i + range).limit(limit).boxed()
				.collect(Collectors.toList());

		List<AvgIMCByAge> avgList = new ArrayList<>();

		for (Integer y : rangeOfYears) {

			AvgIMCByAge avg = new AvgIMCByAge();
			Integer lastYear = ((y + range - 1) <= 100) ? y + range - 1 : 100;
			avg.setAgeRange(String.valueOf(y) + " - " + String.valueOf(lastYear));

			Double averageIMC = donators.stream().filter(donator -> DonatorValidator.verifyYear(donator, y, lastYear))
					.mapToDouble(donator -> DonatorValidator.calcIMC(donator)).average().orElse(0.);

			avg.setImc(BigDecimal.valueOf(averageIMC).setScale(2, RoundingMode.HALF_EVEN));
			avgList.add(avg);
		}

		logger.info("Finsh method averageIMCByAge");
		return avgList;
	}

	public List<GenderOverweight> avgOverweightByGenders() {
		logger.info("Start method avgOverweightByGenders");

		List<Donator> allDonators = donatorRepo.findAll();
		List<Donator> overweightedDonators = allDonators.stream()
				.filter(donator -> DonatorValidator.calcIMC(donator) > 30).collect(Collectors.toList());

		Integer totalOverweight = (overweightedDonators.size() > 0) ? overweightedDonators.size() : 1;
		logger.warn("TOTAL : " + String.valueOf(totalOverweight));
		List<GenderOverweight> owList = new ArrayList<>();

		for (GenderType gender : GenderType.values()) {

			GenderOverweight obj = new GenderOverweight();
			obj.setGender(gender.getCode());

			Long count = overweightedDonators.stream().filter(donator -> donator.getDonatorGender().equals(gender))
					.count();

			Double percentage = (count.doubleValue() / totalOverweight.doubleValue()) * 100;
			logger.warn("percentage : " + String.valueOf(percentage));
			obj.setPercentual(BigDecimal.valueOf(percentage).setScale(2, RoundingMode.HALF_EVEN));
			owList.add(obj);
		}

		logger.info("Finish method avgOverweightByGenders");
		return owList;
	}

	public List<AvgAgeByBlood> avgAgeByBlood(String bloodSpecify) {
		logger.info("Start method avgAgeByBlood");

		List<Donator> donators = donatorRepo.findAll();

		List<AvgAgeByBlood> avgList = new ArrayList<>();

		for (BloodType blood : BloodType.values()) {
			if (!blood.equals(BloodType.decode(bloodSpecify)) && bloodSpecify != null) {
				break;
			}

			AvgAgeByBlood obj = new AvgAgeByBlood();
			obj.setBloodType(blood.getCode());

			Double avgAge = donators.stream()
					.filter(donator -> donator.getDonatorInfo().getDonatorBloodType().equals(blood))
					.mapToLong(donator -> DonatorValidator.getAge(donator.getDonatorBirthdate())).average().orElse(0.);

			obj.setAge(BigDecimal.valueOf(avgAge).setScale(2, RoundingMode.HALF_EVEN));
			avgList.add(obj);
		}

		logger.info("Finish method avgAgeByBlood");
		return avgList;
	}

	public List<DonatorByReceptorBlood> donatorsAmountByReceptorBlood(String bloodSpecify) {
		logger.info("Start method donatorsAmountByReceptorBlood");

		List<Donator> donators = donatorRepo.findAll();

		List<DonatorByReceptorBlood> avgList = new ArrayList<>();

		for (BloodType blood : BloodType.values()) {
			logger.info("Searching for bloodtype donators : " + blood.getCode());
			
			DonatorByReceptorBlood obj = new DonatorByReceptorBlood();
			obj.setReceptorBloodType(blood.getCode());
			
			List<BloodType> donatorBloodList = BloodType.receiverDonatorMap.get(blood);
			Long quantity = 0L;			
			for (BloodType bloodDonator : donatorBloodList) {
				Long validDonators = donators.stream()
						.filter(donator -> DonatorValidator.validateDonator(donator))
						.filter(donator -> donator.getDonatorInfo().getDonatorBloodType().equals(bloodDonator))
						.count();
				quantity += validDonators;
			}
			
			obj.setQuantity(quantity.intValue());
			avgList.add(obj);
		}

		logger.info("Finish method donatorsAmountByReceptorBlood");
		return avgList;
	}

	private Address getValidAddress(DonatorDTO donatorDto) {
		Address address = Address.fromDonatorDto(donatorDto);

		State state = stateRepo.findByName(donatorDto.getEstado());
		City city = (state != null) ? cityRepo.findByNameAndState(donatorDto.getCidade(), state) : null;

		if (city != null && state != null) {
			logger.warn("CITY IS NOT NULL");
			address.setCity(city);

		}
		if (state != null) {
			logger.warn("STATE IS NOT NULL");
			address.getCity().setState(state);
		}
		return address;
	}

	public ResponseMessage saveManyDonator(@Valid DonatorDTOlist body) {
		
		ResponseMessage response = new ResponseMessage();
		// Have to check true checks
		body.forEach(donator -> saveDonator(donator));
		response.setCode("200");
		response.setMessage("Donators recorded: " + String.valueOf(body.size()));
		return response;
		
	}

}
