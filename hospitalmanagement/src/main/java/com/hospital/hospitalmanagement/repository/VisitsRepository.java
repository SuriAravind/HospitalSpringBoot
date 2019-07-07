package com.hospital.hospitalmanagement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hospital.hospitalmanagement.model.Visits;

@Repository
public interface VisitsRepository extends MongoRepository<Visits, String>{

}
