package com.hospitalmanagementwithMysql.hospital.model;

import javax.persistence.Entity;

@Entity
public class Visits {
	
	@javax.persistence.Id
	private String patientId;
	private String providerId;
	private String description;
	public Visits() {
		
	}
	public Visits(String patientId, String providerId, String description) {
		super();
		this.patientId = patientId;
		this.providerId = providerId;
		this.description = description;
	}
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getProviderId() {
		return providerId;
	}
	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
