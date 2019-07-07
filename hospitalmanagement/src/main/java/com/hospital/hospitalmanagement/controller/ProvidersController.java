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

import com.hospital.hospitalmanagement.model.Providers;
import com.hospital.hospitalmanagement.repository.ProvidersRepository;

@RestController
public class ProvidersController
{
	@Autowired
	private ProvidersRepository providerrepo; 
	
	@RequestMapping(value = "/providers/all", method = RequestMethod.GET)
	public List<Providers> gettAll() {
		return providerrepo.findAll();
	}

	@GetMapping("/providers/get/{id}")
	public Optional<Providers> findById(@PathVariable String id) {
		return providerrepo.findById(id);
	}

	@DeleteMapping(value = "/providers/delete/{id}")
	public String deleteById(@PathVariable String id) {
		providerrepo.deleteById(id);
		return "delete successfully";
	}

	@PostMapping(value = "/providers/add")
	public String addMultiple(@RequestBody Iterable<Providers> provider) {
		for (Providers item : provider) {
			providerrepo.insert(item);
		}
		return "insert record successfully";
	}

	@PutMapping(value = "/providers/update/{id}")
	public String updateById(@PathVariable final String id, @RequestBody Providers provider) {
		Providers providerDb = null;
		Optional<Providers> providerOptional = providerrepo.findById(id);
		if (providerOptional.isPresent()) {
			providerDb = providerOptional.get();
		    providerDb.setId(provider.getId());
		    providerDb.setHospitalName(provider.getHospitalName());
		    providerDb.setSpecilizationList(provider.getHospitalName());
		}
		providerDb = providerrepo.save(providerDb);
		return "Update Successfully";
	}
}
