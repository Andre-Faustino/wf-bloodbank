package com.wk.technology.blood.bank.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wk.technology.blood.bank.service.models.donators.Donator;
import com.wk.technology.blood.bank.service.models.donators.DonatorContact;

@Repository
public interface DonatorContactRepository extends JpaRepository<DonatorContact, Long>{

}
