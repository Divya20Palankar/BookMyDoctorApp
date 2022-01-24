package com.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer>
 {

	@Query("Select d from Doctor d where d.speciality=?1")
	List<Doctor> findBySpeciality(String speciality);

	

	

}
