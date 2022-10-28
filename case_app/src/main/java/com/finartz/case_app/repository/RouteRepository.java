package com.finartz.case_app.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.finartz.case_app.model.Route;


public interface RouteRepository extends JpaRepository<Route, Long> {
	
	Optional<Route> findByFromAirportCodeAndToAirportCode(String fromAirportCode, String ToAirportCode);
	
}