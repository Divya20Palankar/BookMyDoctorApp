package com.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Entity.Patient;

public interface PatientRepository  extends JpaRepository<Patient,Integer> {

	//public Patient find(Patient p);
	@Query("Select p from Patient p where p.patientName=:s1 OR p.mobileNo=:s1 OR patientId=:s1 OR email=:s1 OR password=:s1 OR bloodGroup=:s1 OR gender=:s1 OR age=:s1 OR address=:s1 ")
	List<Patient> getPatient(String s1);
}
