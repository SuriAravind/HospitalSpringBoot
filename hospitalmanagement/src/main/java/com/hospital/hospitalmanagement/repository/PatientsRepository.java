package com.hospital.hospitalmanagement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hospital.hospitalmanagement.model.Patients;

public interface PatientsRepository extends MongoRepository<Patients, String> {

}
