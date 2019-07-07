package com.hospital.hospitalmanagement.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("visits")
public class Visits {
	@Id
	private String patientId;
	private String providerId;
	private String description;
	
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
