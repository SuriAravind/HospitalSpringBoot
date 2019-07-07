package com.hospitalmanagementwithMysql.hospital.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospitalmanagementwithMysql.hospital.model.Patients;
import com.hospitalmanagementwithMysql.hospital.repository.PatientsRepository;

@Service
public class PatientService {
	@Autowired
	private PatientsRepository patientrepo;

	public List<Patients> getAll() {
		return (List<Patients>) patientrepo.findAll();
	}

	public Optional<Patients> findById(String id) {
		return patientrepo.findById(id);
	}

	public String deleteById(String id) {
		patientrepo.deleteById(id);
		return "delete successfully";
	}

	public String add(Iterable<Patients> patient) {
		String msg = "";
		for (Patients item : patient) {
			if (!(patientrepo.existsById(item.getId()))) {
				patientrepo.save(item);
				msg += "insert record successfully";
			} else {
				msg += "insert record not successfully";
			}
		}
		return msg;
	}
	public String updateById(final String id, Patients patient) {
		Patients patientDb = null;
		Optional<Patients> patientOptional = patientrepo.findById(id);
		if (patientOptional.isPresent()) {
			patientDb = patientOptional.get();
			patientDb.setId(patient.getId());
			patientDb.setFirstName(patient.getFirstName());
			patientDb.setLastName(patient.getLastName());
		}
		patientDb = patientrepo.save(patientDb);
		return "Update Successfully";
	}
	public List<Patients> getGreathanId(final String id)
	{
		return patientrepo.findByWhereId(id);
	}
    public int recordCount()
    {
		return (int)patientrepo.count();
    	
    }
	
}
