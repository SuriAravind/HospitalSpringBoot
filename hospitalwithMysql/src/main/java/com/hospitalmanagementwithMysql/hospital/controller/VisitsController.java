package com.hospitalmanagementwithMysql.hospital.controller;

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

import com.hospitalmanagementwithMysql.hospital.model.Visits;
import com.hospitalmanagementwithMysql.hospital.service.VisitService;


@RestController
public class VisitsController{
	@Autowired
	VisitService visitService;
	
	@PostMapping(value = "/visits/add")
	@RequestMapping(value = "/visits/all", method = RequestMethod.GET)
	public List<Visits> gettAll() {
		return (List<Visits>) visitService.getAll();
	}

	@GetMapping("/visits/get/{id}")
	public Optional<Visits> findById(@PathVariable String id) {
		return visitService.findById(id);
	}

	@DeleteMapping(value = "/visits/delete/{id}")
	public String deleteById(@PathVariable String id) {
		return visitService.deleteById(id);
	}
	@GetMapping("/patientvisit/get/{id}")
	public Optional<Visits> findByPatientId(@PathVariable String id) {
		return visitService.findById(id);
	}
	@PutMapping(value = "/visits/update/{id}")
	public String updateById(@PathVariable final String id, @RequestBody Visits visit) {
			return visitService.updateById(id, visit);
	}
	@GetMapping(value="/getvisitspatient/{id}")
	public List<Visits> getPatientIdInVisit(@PathVariable final String id)
	{
		return visitService.getPatientIdInVisit(id);
	}
	
    @GetMapping(value="/percentage")
	public int getpercent()
	{
    	return visitService.getMatchPercnetage();
    }
	
}
