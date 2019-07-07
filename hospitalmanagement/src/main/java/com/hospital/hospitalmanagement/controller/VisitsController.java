package com.hospital.hospitalmanagement.controller;

import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.json.JSONObject;
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

import com.hospital.hospitalmanagement.model.Visits;
import com.hospital.hospitalmanagement.repository.VisitsRepository;

@RestController
public class VisitsController{
	
	@Autowired
	private VisitsRepository visitsrepo;
	@PostMapping(value = "/visits/add")
	public String add(@RequestBody Iterable<Visits> visit) {
        for (Visits item : visit) 
		{
			visitsrepo.insert(item);
		}
		return "insert record successfully";
	}
	@RequestMapping(value = "/visits/all", method = RequestMethod.GET)
	public List<Visits> gettAll() {
		return visitsrepo.findAll();
	}

	@GetMapping("/visits/get/{id}")
	public Optional<Visits> findById(@PathVariable String id) {
		return visitsrepo.findById(id);
	}

	@DeleteMapping(value = "/visits/delete/{id}")
	public String deleteById(@PathVariable String id) {
		visitsrepo.deleteById(id);
		return "delete successfully";
	}
	@GetMapping("/patientvisit/get/{id}")
	public Optional<Visits> findByPatientId(@PathVariable String id) {
		
		return visitsrepo.findById(id);
	}
	@PutMapping(value = "/visits/update/{id}")
	public String updateById(@PathVariable final String id, @RequestBody Visits visit) {
		Visits visitDb = null;
		Optional<Visits> visitOptional = visitsrepo.findById(id);
		if (visitOptional.isPresent()) {
			visitDb = visitOptional.get();
		    visitDb.setPatientId(visit.getPatientId());
		    visitDb.setProviderId(visit.getProviderId());
		    visitDb.setDescription(visit.getDescription());
		    
		}
		visitDb = visitsrepo.save(visitDb);
		return "Update Successfully";
	}
}
