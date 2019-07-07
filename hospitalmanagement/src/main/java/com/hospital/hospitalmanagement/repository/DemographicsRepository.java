package com.hospital.hospitalmanagement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hospital.hospitalmanagement.model.Demographics;

@Repository
public interface DemographicsRepository extends MongoRepository<Demographics,String>{

}
