package com.hospital.hospitalmanagement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hospital.hospitalmanagement.model.Providers;
@Repository
public interface ProvidersRepository extends MongoRepository<Providers, String>{

}
