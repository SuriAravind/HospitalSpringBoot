package com.hospitalmanagementwithMysql.hospital.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hospitalmanagementwithMysql.hospital.model.Patients;
import com.hospitalmanagementwithMysql.hospital.repository.PatientsRepository;
import com.hospitalmanagementwithMysql.hospital.service.PatientService;

@RestController
public class PatientsController {

	@Autowired
	PatientService patientService;

	@RequestMapping(value = "/patients/all", method = RequestMethod.GET)
	public List<Patients> getAll() {
		return (List<Patients>) patientService.getAll();
	}

	@GetMapping("/patients/get/{id}")
	public Optional<Patients> findById(@PathVariable String id) {
		return patientService.findById(id);
	}

	@DeleteMapping(value = "/patients/delete/{id}")
	public String deleteById(@PathVariable String id) {

		return patientService.deleteById(id);
	}

	@PostMapping(value = "/patients/add")
	public String add(@RequestBody Iterable<Patients> patient) {
		return patientService.add(patient);
	}

	@PutMapping(value = "/patients/update/{id}")
	public String updateById(@PathVariable final String id, @RequestBody Patients patient) {
		return patientService.updateById(id, patient);
	}

	@GetMapping(value = "/patients/getGreaterThanId/{id}")
	public List<Patients> getGreathanId(@PathVariable final String id) {
		return patientService.getGreathanId(id);
	}

}
