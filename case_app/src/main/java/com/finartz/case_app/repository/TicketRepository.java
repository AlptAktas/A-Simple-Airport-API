package com.finartz.case_app.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.finartz.case_app.model.Ticket;


public interface TicketRepository extends JpaRepository<Ticket, Long> {
	
	Optional<Ticket> findByFlightID(Long flightID);
	Optional<Ticket> findByFlightNumber(String flightNumber);
	
}