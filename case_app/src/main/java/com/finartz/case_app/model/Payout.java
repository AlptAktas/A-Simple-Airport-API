package com.finartz.case_app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payouts")

final public class Payout {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "flightNumber")
	private String flightNumber;
	
	@Column(name = "flightID")
	private Long flightID;
	
	@Column(name = "ticketOwnerName")
	private String ticketOwnerName;
	
	@Column(name = "cardHolderName")
	private String cardHolderName;
	
	@Column(name = "cardNumber")
	private String cardNumber;
	
	@Column(name = "lastDate")
	private String lastDate;
	
	@Column(name = "cv")
	private String cv;

	
	//Constructor
	public Payout() {
	}
	
	public Payout(String flightNumber, String cardHolderName, String cardNumber, String lastDate, String cv) {
		this.flightNumber = flightNumber;
		this.cardHolderName = cardHolderName;
		this.cardNumber = lastDate;
		this.lastDate = lastDate;
		this.cv = cv;
	}
	
	//get id
	public long getID() {
		return this.id;
	}
	
	//get flight number
	public String getFlightNumber() {
		return this.flightNumber;
	}
	
	//set flight number
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	
	//get flight id
	public Long getFlightID() {
		return flightID;
	}
	
	//set flight id
	public void setFlightID(Long flightID) {
		this.flightID = flightID;
	}
	
	public String getTicketOwnerName() {
		return ticketOwnerName;
	}
	
	public void setTicketOwnerName(String ticketOwnerName) {
		this.ticketOwnerName = ticketOwnerName;
	}
	
	//get card holder name
	public String getCardHolderName() {
		return this.cardHolderName;
	}
	
	//set car holder name
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	
	//get card number
	public String getCardNumber() {
		return mask(cardNumber);
	}
	
	//set card number
	public void setCardNumber(String cardNumber) {
		
		this.cardNumber = rep(cardNumber);
	}
	
	//get last date
	public String getLastDate() {
		return lastDate;
	}
	
	//set last date
	public void setLastDate(String lastDate) {
		this.lastDate = lastDate;
	}	
	
	//get cv
	public String getCv() {
		return this.cv;
	}
	
	//set cv
	public void setCv(String cv) {
		this.cv = cv;
	}
	
	//replace the number
	private String rep(String no) {
		if (no.matches("^[0-9]+$")) {
			return no;
		}
		return no.replaceAll("\\D", "");
	}
	
	// mask the number
	private String mask(String no) {
		final int s_lenght = 6;   
	    final int f_length = 4;
	    int masked_length = no.length() - (s_lenght + f_length);
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < masked_length; i++) {
			str.append("*");
	    }
	    String masked = no.substring(0, s_lenght) + str + no.substring(no.length() - f_length, no.length());
		return masked;
	}

}
