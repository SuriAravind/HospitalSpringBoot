package com.hospitalmanagementwithMysql.hospital.model;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity

public class Patients {
    
	@javax.persistence.Id
	private String id;
	
	private String firstName;
	
	private String lastName;
    
	public Patients()
	{
		
	}
	public Patients(String id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

		    	
}
