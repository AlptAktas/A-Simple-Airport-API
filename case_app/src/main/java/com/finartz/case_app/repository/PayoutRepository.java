package com.finartz.case_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finartz.case_app.model.Payout;


public interface PayoutRepository extends JpaRepository<Payout, Long> {
	
}