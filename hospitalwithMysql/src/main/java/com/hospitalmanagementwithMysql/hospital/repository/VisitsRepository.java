package com.hospitalmanagementwithMysql.hospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hospitalmanagementwithMysql.hospital.model.Visits;

@Repository
public interface VisitsRepository extends CrudRepository<Visits, String> {
	 

	 @Query(value = "SELECT p FROM Visits p WHERE p.patientId = :id1")
	 public List<Visits> findvisit(@Param("id1")String id1);
	 @Query("select count(*) from Patients p where p.id not in (select v.patientId from Visits v)")
     public int percentage();
}
