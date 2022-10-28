package com.finartz.case_app.model;

import javax.persistence.*;

@Entity
@Table(name = "airlines")

public class Airline {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "code")
	private String code;
	
	//constructor
	public Airline() {
	}

	public Airline(String name, String code) {
		this.name = name;
		this.code = code;
	}
	
	//get airline id
	public long getID() {
		return this.id;
	}
	
	//get airline name
	public String getName() {
		return this.name;
	}
	
	//get airline code
	public String getCode() {
		return this.code;
	}
	
	//set airline name
	public void setName(String name) {
		this.name = name;
	}
	
	//set airline code
	public void setCode(String code) {
		this.code = code;
	}
	
}