package com.finartz.case_app.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.finartz.case_app.model.Airline;


public interface AirlineRepository extends JpaRepository<Airline, Long> {
	
	Optional<Airline> findByCode(String code);

}