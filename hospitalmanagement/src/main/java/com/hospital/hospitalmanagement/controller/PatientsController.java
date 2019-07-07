package com.hospital.hospitalmanagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.hospitalmanagement.model.Patients;
import com.hospital.hospitalmanagement.repository.PatientsRepository;

@RestController
public class PatientsController {

	@Autowired
	PatientsRepository patientrepo;

	@RequestMapping(value = "/patients/all", method = RequestMethod.GET)
	public List<Patients> gettAll() {
		return patientrepo.findAll();
	}

	@GetMapping("/patients/get/{id}")
	public Optional<Patients> findById(@PathVariable String id) {
		return patientrepo.findById(id);
	}

	@DeleteMapping(value = "/patients/delete/{id}")
	public String deleteById(@PathVariable String id) {
		patientrepo.deleteById(id);
		return "delete successfully";
	}

	@PostMapping(value = "/patients/add")
	public String add(@RequestBody Iterable<Patients> patient) {
		for (Patients item : patient) {
			patientrepo.insert(item);
		}
		return "insert record successfully";
	}

	@PutMapping(value = "/patients/update/{id}")
	public String updateById(@PathVariable final String id, @RequestBody Patients patient) {
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

}
