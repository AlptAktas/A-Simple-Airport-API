package com.finartz.case_app.model;

import javax.persistence.*;

@Entity
@Table(name = "tickets")

public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "ticketOwnerName")
	private String ticketOwnerName;
	
	@Column(name = "flightID")
	private Long flightID;
	
	@Column(name = "flightNumber")
	private String flightNumber;

	
	public Ticket() {
		
	}
	
	public Ticket(String ticketOwnerName, long flightID, String flightNumber) {
		this.ticketOwnerName = ticketOwnerName;
		this.flightID = flightID;
		this.flightNumber = flightNumber;
	}
	
	//get id
	public long getId() {
		return this.id;
	}
	
	//get ticket owner
	public String getTicketOwnerName() {
		return ticketOwnerName;
	}
	
	//set ticket owner
	public void setTicketOwnerName(String ticketOwnerName) {
		this.ticketOwnerName = ticketOwnerName;
	}
	
	//get flightID
	public long getFlightID() {
		return flightID;
	}
	
	//set flightID
	public void setFlightID(long flightID) {
		this.flightID = flightID;
	}
	
	//get flightID
	public String getFlightNumber() {
		return flightNumber;
	}
	
	//set flightID
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	
	

}
