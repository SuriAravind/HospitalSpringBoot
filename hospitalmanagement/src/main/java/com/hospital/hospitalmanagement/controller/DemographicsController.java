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

import com.hospital.hospitalmanagement.model.Demographics;
import com.hospital.hospitalmanagement.repository.DemographicsRepository;
@RestController
public class DemographicsController {

	@Autowired
	private DemographicsRepository demorepo;
	
	@RequestMapping(value = "/demographics/all", method = RequestMethod.GET)
	public List<Demographics> gettAll() {
		return demorepo.findAll();
	}

	@GetMapping("/demographics/get/{id}")
	public Optional<Demographics> findById(@PathVariable String id) {
		return demorepo.findById(id);
	}
	
	@DeleteMapping(value = "/demographics/delete/{id}")
	public String deleteById(@PathVariable String id) {
		demorepo.deleteById(id);
		return "delete successfully";
	}

	@PostMapping(value = "/demographics/add")
	public String add(@RequestBody Iterable<Demographics> demo) {
		for (Demographics item : demo) {
			demorepo.insert(item);
		}
		return "insert record successfully";
	}
	@PutMapping(value = "/demographics/update/{id}")
	public String updateById(@PathVariable final String id, @RequestBody Demographics demo) {
		Demographics demoDb = null;
		Optional<Demographics> patientOptional = demorepo.findById(id);
		if (patientOptional.isPresent()) {
			demoDb = patientOptional.get();
		    demoDb.setId(demo.getId());
		    demoDb.setAddress(demo.getAddress());
		    demoDb.setPatientsId(demo.getPatientsId());
		}
		demoDb = demorepo.save(demoDb);
		return "Update Successfully";
	}
}
