package com.finartz.case_app.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.finartz.case_app.model.Airport;


public interface AirportRepository extends JpaRepository<Airport, Long> {
	
	Optional<Airport> findByCode(String code);
	
}