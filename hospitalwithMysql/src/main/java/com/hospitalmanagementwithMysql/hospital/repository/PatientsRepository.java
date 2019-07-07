package com.hospitalmanagementwithMysql.hospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hospitalmanagementwithMysql.hospital.model.Patients;

@Repository
public interface PatientsRepository extends CrudRepository<Patients,String>{
	 
	 @Query(value = "SELECT p FROM Patients p WHERE p.id >:id1")
	 public List<Patients> findByWhereId(@Param("id1")String id1);
}
