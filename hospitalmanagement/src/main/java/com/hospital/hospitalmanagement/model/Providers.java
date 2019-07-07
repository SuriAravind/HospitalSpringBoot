package com.hospital.hospitalmanagement.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("providers")
public class Providers {

	private String id;
	private String hospitalName;
	private String specilizationList;
	public Providers(String id, String hospitalName, String specilizationList) {
		super();
		this.id = id;
		this.hospitalName = hospitalName;
		this.specilizationList = specilizationList;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	
	public String getSpecilizationList() {
		return specilizationList;
	}
	public void setSpecilizationList(String specilizationList) {
		this.specilizationList = specilizationList;
	}
	
}
