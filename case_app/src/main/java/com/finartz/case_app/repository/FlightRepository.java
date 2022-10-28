package com.finartz.case_app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finartz.case_app.model.Flight;


public interface FlightRepository extends JpaRepository<Flight, Long> {
	
	Optional<Flight> findByAirlineCode(String airlineCode);
	Optional<Flight> findByFromAirportCode(String fromAirportCode);
	Optional<Flight> findByToAirportCode(String toAirportCode);
	Optional<Flight> findByFlightNumber(String flightNumber);
	
}