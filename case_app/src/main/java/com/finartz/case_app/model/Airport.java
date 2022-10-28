package com.finartz.case_app.model;

import javax.persistence.*;

@Entity
@Table(name = "airports")

public class Airport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "code")
	private String code;
	
	
	//constructor
	public Airport() {
		
	}
	
	public Airport(String name, String code) {
		this.name = name;
		this.code = code;

	}
	
	//get Id
	public long getId() {
		return id;
	}
	
	
	//get airport name
	public String getName() {
		return name;
	}
	
	//get airport code
	public String getCode() {
		return code;
	}
	
	//set airport name
	public void setName(String name) {
		this.name = name;
	}
	
	//set airport code
	public void setCode(String code) {
		this.code = code;
	}	
	
}
