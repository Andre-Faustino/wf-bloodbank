package com.wk.technology.blood.bank.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wk.technology.blood.bank.service.models.locations.State;

@Repository
public interface StateRepository extends JpaRepository<State, Long>{

	State findByName(String State);
	
}
