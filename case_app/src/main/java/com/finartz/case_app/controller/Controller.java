package com.finartz.case_app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finartz.case_app.model.*;
import com.finartz.case_app.repository.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")

public class Controller {
	
	@Autowired
	AirlineRepository airlineRepository;
	
	@Autowired
	AirportRepository airportRepository;
	
	@Autowired
	RouteRepository routeRepository;
	
	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	PayoutRepository payoutRepository; 
	
	/*
	@PostMapping("/airlines")
	public Airline createAirline(@RequestBody Airline airline) {
		
		List<Airline> list = airlineRepository.findAll();
		
		if (list.isEmpty() || list.size() == 0) {
			
			return airlineRepository.save(airline);
		}
		
		else {
			Optional<Airline> airline_list = airlineRepository.findByCode(airline.getCode());
			
			if (airline_list.isPresent()) {
				
			}
			return airlineRepository.save(airline);
			
		}
	 }
	*/
	
	//get all airlines
	@GetMapping("/airlines")
	public ResponseEntity<List<Airline>> getAllAirlines() {
		
		try {
			List<Airline> list = airlineRepository.findAll();
			
			if (list.isEmpty() || list.size() == 0) {
				
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(list, HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//get airline by id
	@GetMapping("/airlines/id={id}")
	public ResponseEntity<Airline> getAirlineById(@PathVariable(value = "id") Long id) {
		
		Optional<Airline> airline = airlineRepository.findById(id);
		
		if (airline.isPresent()) {
			return new ResponseEntity<>(airline.get(), HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	 }
		
	//get airline by code
	@GetMapping("/airlines/code={code}")
	public ResponseEntity<Airline> getAirlineByCode(@PathVariable(value = "code") String code) {
		
		Optional<Airline> airline = airlineRepository.findByCode(code);
		
		if (airline.isPresent()) {
			return new ResponseEntity<>(airline.get(), HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);


	 }
	
	@PostMapping("/airlines")
	public ResponseEntity<Airline> postAirline(@RequestBody Airline airline) {
		
		Optional<Airline> airline_test = airlineRepository.findByCode(airline.getCode());
		
		if (airline.getName().isEmpty() || airline.getCode().isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		if (airline_test.isPresent()) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
		return new ResponseEntity<>(airlineRepository.save(airline), HttpStatus.OK);

	 }
	
	
	//get all airports
	@GetMapping("/airports")
	public ResponseEntity<List<Airport>> getAllAirports() {
			
		try {
			List<Airport> list = airportRepository.findAll();
				
			if (list.isEmpty() || list.size() == 0) {
					
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
				
			return new ResponseEntity<>(list, HttpStatus.OK);
				
		} catch (Exception e) {
				
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//get airport by id
	@GetMapping("/airports/id={id}")
	public ResponseEntity<Airport> getAirportById(@PathVariable(value = "id") Long id) {
		
		Optional<Airport> airport = airportRepository.findById(id);
		
		if (airport.isPresent()) {
			return new ResponseEntity<>(airport.get(), HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	 }
		
	//get airport by code
	@GetMapping("/airports/code={code}")
	public ResponseEntity<Airport> getAirportByCode(@PathVariable(value = "code") String code) {
		
		Optional<Airport> airport = airportRepository.findByCode(code);
		
		if (airport.isPresent()) {
			return new ResponseEntity<>(airport.get(), HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);


	 }
	
	@PostMapping("/airports")
	public ResponseEntity<Airport> postAirport(@RequestBody Airport airport) {
		
		Optional<Airport> airport_list = airportRepository.findByCode(airport.getCode());
		
		if(airport.getName().isEmpty() || airport.getCode().isEmpty()) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		if (airport_list.isPresent()) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
		
		return new ResponseEntity<>(airportRepository.save(airport), HttpStatus.OK);

	 }
	
	//get all routes
	@GetMapping("/routes")
	public ResponseEntity<List<Route>> getAllRoutes() {
		
		try {
			List<Route> list = routeRepository.findAll();
			
			if (list.isEmpty() || list.size() == 0) {
				
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(list, HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//get route by id
	@GetMapping("/routes/id={id}")
	public ResponseEntity<Route> getRoutebyId(@PathVariable(value = "id") Long id) {
		
		Optional<Route> route = routeRepository.findById(id);
		
		if (route.isPresent()) {
			return new ResponseEntity<>(route.get(), HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	 }
	
	//post route
	@PostMapping("/routes")
	public ResponseEntity<Route> postRoute(@RequestBody Route route) {
		
		Optional<Airport> from_airport = airportRepository.findByCode(route.getFromAirportCode());
		Optional<Airport> to_airport = airportRepository.findByCode(route.getToAirportCode());
		
		Optional<Route> route_test = routeRepository.findByFromAirportCodeAndToAirportCode(route.getFromAirportCode(), route.getToAirportCode());
		
		if(route.getFromAirportCode().isEmpty() || route.getToAirportCode().isEmpty()) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		if (route_test.isPresent()) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
		if (from_airport.isPresent() && to_airport.isPresent()) {
			Airport fr_a = from_airport.get();
			Airport tr_a = to_airport.get();
			route.setFromAirportName(fr_a.getName());
			route.setToAirportName(tr_a.getName());
			
			return new ResponseEntity<>(routeRepository.save(route), HttpStatus.OK);
			
		}
		
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}
	
	//get all flights
	@GetMapping("/flights")
	public ResponseEntity<List<Flight>> getAllFlights() {
			
		try {
			List<Flight> list = flightRepository.findAll();
				
			if (list.isEmpty() || list.size() == 0) {
					
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
				
			return new ResponseEntity<>(list, HttpStatus.OK);
				
		} catch (Exception e) {
				
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
		
	//get flight by id
	@GetMapping("/flights/id={id}")
	public ResponseEntity<Flight> getFlightById(@PathVariable(value = "id") Long id) {
			
		Optional<Flight> flight = flightRepository.findById(id);
			
		if (flight.isPresent()) {
			return new ResponseEntity<>(flight.get(), HttpStatus.OK);
		}
			
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}
	
	//get flight by airline
	@GetMapping("/flights/airline={airlineCode}")
	public ResponseEntity<Flight> getFlightByAirline(@PathVariable(value = "airlineCode") String airlineCode) {
			
		Optional<Flight> flight = flightRepository.findByAirlineCode(airlineCode);
			
		if (flight.isPresent()) {
			return new ResponseEntity<>(flight.get(), HttpStatus.OK);
		}
			
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}
	
	//get flight by departure airport
	@GetMapping("/flights/departure={fromAirportCode}")
	public ResponseEntity<Flight> getFlightByFromAirportCode(@PathVariable(value = "fromAirportCode") String fromAirportCode) {
			
		Optional<Flight> flight = flightRepository.findByFromAirportCode(fromAirportCode);
			
		if (flight.isPresent()) {
			return new ResponseEntity<>(flight.get(), HttpStatus.OK);
		}
			
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}
	
	//get flight by destination airport
	@GetMapping("/flights/dest={toAirportCode}")
	public ResponseEntity<Flight> getFlightByToAirportCode(@PathVariable(value = "toAirportCode") String toAirportCode) {
			
		Optional<Flight> flight = flightRepository.findByToAirportCode(toAirportCode);
			
		if (flight.isPresent()) {
			return new ResponseEntity<>(flight.get(), HttpStatus.OK);
		}
			
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}
	
	//post flight
	@PostMapping("/flights")
	public ResponseEntity<Flight> postFlight(@RequestBody Flight flight) {
		
		Optional<Flight> flight_test = flightRepository.findByFlightNumber(flight.getFlightNumber());
			
		Optional<Airline> airline_test = airlineRepository.findByCode(flight.getAirlineCode());
			
		Optional<Airport> from_airport = airportRepository.findByCode(flight.getFromAirportCode());
		Optional<Airport> to_airport = airportRepository.findByCode(flight.getToAirportCode());
			
		Optional<Route> route_test = routeRepository.findByFromAirportCodeAndToAirportCode(flight.getFromAirportCode(), 
																							flight.getToAirportCode());
			
		if (airline_test.isEmpty()) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		if (flight_test.isPresent()) {
			
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
			
		if (from_airport.isEmpty() && to_airport.isEmpty()) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		if (route_test.isEmpty()) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		Airline arp = airline_test.get();
		Airport fr_a = from_airport.get();
		Airport tr_a = to_airport.get();
		
		flight.setAirlineName(arp.getName());
		flight.setAirlineCode(arp.getCode());
		flight.setFromAirportName(fr_a.getName());
		flight.setFromAirportCode(fr_a.getCode());
		flight.setToAirportName(tr_a.getName());
		flight.setToAirportCode(tr_a.getCode());
		
			
		return new ResponseEntity<>(flightRepository.save(flight), HttpStatus.OK);
	}
	//post payout
	@PostMapping("/payout")
	public ResponseEntity<Payout> postPayout(@RequestBody Payout payout) {
		
		Optional<Flight> flight = flightRepository.findByFlightNumber(payout.getFlightNumber());
			
		if (flight.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		flight.get().updatePrice();
		return new ResponseEntity<>(payoutRepository.save(payout), HttpStatus.OK);
	}
	

}