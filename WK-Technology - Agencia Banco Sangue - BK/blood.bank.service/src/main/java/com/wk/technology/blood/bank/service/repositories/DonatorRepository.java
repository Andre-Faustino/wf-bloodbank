package com.wk.technology.blood.bank.service.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wk.technology.blood.bank.service.dtos.DonatorsByStateDTO;
import com.wk.technology.blood.bank.service.models.donators.Donator;
import com.wk.technology.blood.bank.service.swagger.models.DonatorsByState;

@Repository
public interface DonatorRepository extends JpaRepository<Donator, Long>{
	
	@Query("SELECT new com.wk.technology.blood.bank.service.dtos.DonatorsByStateDTO"
			+ "(s.name AS state, COUNT(d.id) AS amount) "
			+ "FROM Donator d "
			+ "LEFT JOIN d.donatorAddress.city.state as s "			
			+ "GROUP BY s.id")
	List<DonatorsByStateDTO> countDonatorsByState();
	
	@Query("SELECT new com.wk.technology.blood.bank.service.dtos.DonatorsByStateDTO"
			+ "(s.name AS state, COUNT(d.id) AS amount) "
			+ "FROM Donator d "
			+ "LEFT JOIN d.donatorAddress.city.state as s "
			+ "WHERE s.name = ?1 "
			+ "GROUP BY s.id")
	List<DonatorsByStateDTO> countDonatorsByState(String name);
}
