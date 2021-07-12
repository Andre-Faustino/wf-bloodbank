package com.wk.technology.blood.bank.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wk.technology.blood.bank.service.models.locations.City;
import com.wk.technology.blood.bank.service.models.locations.State;

@Repository
public interface CityRepository extends JpaRepository<City, Long>{

	City findByNameAndState(String City, State State);
}
