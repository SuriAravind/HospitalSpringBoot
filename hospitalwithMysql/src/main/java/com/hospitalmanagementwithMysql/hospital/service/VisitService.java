package com.hospitalmanagementwithMysql.hospital.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospitalmanagementwithMysql.hospital.model.Visits;
import com.hospitalmanagementwithMysql.hospital.repository.PatientsRepository;
import com.hospitalmanagementwithMysql.hospital.repository.VisitsRepository;

@Service
public class VisitService {

	@Autowired
	private VisitsRepository visitsrepo;
	@Autowired
	PatientService patient;
	public List<Visits> getAll()
	{
		return (List<Visits>) visitsrepo.findAll();
	}
   public Optional<Visits> findById(String id) {
		return visitsrepo.findById(id);
	}

	public String deleteById(String id) {
		visitsrepo.deleteById(id);
		return "delete successfully";
	}

	public String add(Iterable<Visits> patient) {
		String msg = "";
		for (Visits item : patient) {
			if (!(visitsrepo.existsById(item.getPatientId()))) {
				visitsrepo.save(item);
				msg += "insert record successfully";
			} else {
				msg += "insert record not successfully";
			}
		}
		return msg;
	}
	public String updateById(final String id, Visits patient) {
		Visits patientDb = null;
		Optional<Visits> patientOptional = visitsrepo.findById(id);
		if (patientOptional.isPresent()) {
			patientDb = patientOptional.get();
			patientDb.setPatientId(patient.getPatientId());
			patientDb.setProviderId(patient.getProviderId());
			patientDb.setDescription(patient.getDescription());
		}
		patientDb = visitsrepo.save(patientDb);
		return "Update Successfully";
	}

	public int getTableCount() {
		
		return (int)visitsrepo.count();
	}
	public List<Visits> getPatientIdInVisit( final String id)
	{
		return visitsrepo.findvisit(id);
	}
	public int getMatchPercnetage()
	{
		int patientCount=patient.recordCount();
		int matchCount=visitsrepo.percentage();
		int percentage=((patientCount-matchCount)*100);
	    return (percentage/patientCount);
	}
}
