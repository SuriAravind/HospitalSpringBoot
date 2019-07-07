package com.hospital.hospitalmanagement.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("demographics")
public class Demographics {

	private String id;
	private String address;
	private String patientsId;
	public Demographics(String id, String address, String patientsId) {
		super();
		this.id = id;
		this.address = address;
		this.patientsId = patientsId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPatientsId() {
		return patientsId;
	}
	public void setPatientsId(String patientsId) {
		this.patientsId = patientsId;
	}
	
}
