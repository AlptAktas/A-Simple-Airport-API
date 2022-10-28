package com.finartz.case_app.model;

import javax.persistence.*;

@Entity
@Table(name = "routes")

public class Route {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "fromAirportName")
	private String fromAirportName;
	
	@Column(name = "fromAirportCode")
	private String fromAirportCode;
	
	@Column(name = "toAirportName")
	private String toAirportName;
	
	@Column(name = "toAirportCode")
	private String toAirportCode;
	
	//constructor
	public Route() {
		
	}
	
	public Route(String fromAirportCode, String toAirportCode) {
		this.fromAirportCode = fromAirportCode;
		this.toAirportCode = toAirportCode;
	}
	
	public Route(String fromAirportName, String fromAirportCode, String toAirportName, String toAirportCode) {
		this.fromAirportName = fromAirportName;
		this.fromAirportCode = fromAirportCode;
		this.toAirportName = toAirportName;
		this.toAirportCode = toAirportCode;
	}

	//get route id
	public long getId() {
		return this.id;
	}
	
	//get from airport name
	public String getFromAirportName() {
		return this.fromAirportName;
	}
	
	//set from airport name
	public void setFromAirportName(String name) {
		this.fromAirportName = name;
	}
		
	//get from code
	public String getFromAirportCode() {
		return this.fromAirportCode;
	}
	
	//set from airport code
	public void setFromAirportCode(String code) {
		this.fromAirportCode = code;
	}
	
	//get to airport name
	public String getToAirportName() {
		return this.toAirportName;
	}
	
	//set to airport name
	public void setToAirportName(String name) {
		this.toAirportName = name;
	}
	
	//get to code
	public String getToAirportCode() {
		return this.toAirportCode;
	}

	//set to airport code
	public void setToAirportCode(String code) {
		this.toAirportCode = code;
	}
}
