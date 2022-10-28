package com.finartz.case_app.model;

import javax.persistence.*;

@Entity
@Table(name = "flights")

public class Flight {
	
	private int firstCapacity;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	//airline adı lazım
	
	@Column(name = "airlineName")
	private String airlineName;
	
	@Column(name = "airlineCode")
	private String airlineCode;
	
	@Column(name = "flightNumber")
	private String flightNumber;
	
	//burada route class eklenecek
	@Column(name = "fromAirportName")
	private String fromAirportName;
	
	@Column(name = "fromAirportCode")
	private String fromAirportCode;
	
	@Column(name = "toAirportName")
	private String toAirportName;
	
	@Column(name = "toAirportCode")
	private String toAirportCode;

    //LocalDateTime departure;
    //LocalDateTime arrival;
	
	@Column(name = "capacity")
	private int capacity;
	
	@Column(name = "price")
	private Double price;
	
	//Constructor
	public Flight() {
	}
	
	public Flight(String airlineCode, String flightNumber, 
			String fromAirportCode, String toAirportCode, 
			int capacity, Double price) {
		this.airlineCode = airlineCode;
		this.flightNumber = flightNumber;
		this.fromAirportCode = fromAirportCode;
		this.toAirportCode = toAirportCode;
		this.capacity = capacity;
		this.setFirstCapacity(capacity);
		this.price = price;
		
	}
	
	
	public Flight(String airlineName, String airlineCode, String flightNumber, 
			String fromAirportName, String fromAirportCode, 
			String toAirportName, String toAirportCode, 
			int capacity, Double price) {
		this.airlineName = airlineName;
		this.airlineCode = airlineCode;
		this.flightNumber = flightNumber;
		this.fromAirportName = fromAirportName;
		this.fromAirportCode = fromAirportCode;
		this.toAirportName = toAirportName;
		this.toAirportCode = toAirportCode;
		this.capacity = capacity;
		this.setFirstCapacity(capacity);
		this.price = price;
	}
	
	//get flight id
	public long getID() {
		return this.id;
	}
	
	//get airline name
	public String getAirlineName() {
		return airlineName;
	}
	
	//set airline name
	public void setAirlineName(String airline_name) {
		this.airlineName = airline_name;
	}
	
	//get airline code
	public String getAirlineCode() {
		return airlineCode;
	}
	
	//set airline code
	public void setAirlineCode(String airline_code) {
		this.airlineCode = airline_code;
	}
	
	//get flight number
	public String getFlightNumber() {
		return flightNumber;
	}
	
	//set flight number
	public void setFlightNumber(String no) {
		this.flightNumber = no;
	}

	//get from airport name
	public String getFromAirportName() {
		return fromAirportName;
	}
	
	//set from airport name
	public void setFromAirportName(String name) {
		this.fromAirportName = name;
	}
	
	//get from airport code
	public String getFromAirportCode() {
		return fromAirportCode;
	}
	
	//set from airport code
	public void setFromAirportCode(String code) {
		this.fromAirportCode = code;
	}
	
	//get to airport name
	public String getToAirportName() {
		return toAirportName;
	}
	
	//set to airport name
	public void setToAirportName(String name) {
		this.toAirportName = name;
	}
	
	//get to airport code
	public String getToAirportCode() {
		return toAirportCode;
	}
	
	//set to airport code
	public void setToAirportCode(String code) {
		this.toAirportCode = code;
	}
	
	//get capacity
	public int getCapacity() {
		return capacity;
	}
	
	//set capacity
	public void setCapacity(int cap) {
		this.capacity = cap;
	}
	
	//get price
	public Double getPrice() {
		return price;
	}
	
	//set price
	public void setPrice(Double p) {
		this.price = p;
	}

	public int getFirstCapacity() {
		return firstCapacity;
	}

	public void setFirstCapacity(int capacity) {
		this.firstCapacity = capacity;
	}
	
	public void updatePrice() {
		if (this.capacity <= (this.firstCapacity*0.9)) {
			price = price * 1.1;
			this.setFirstCapacity(capacity);
		}
	}
	
}
