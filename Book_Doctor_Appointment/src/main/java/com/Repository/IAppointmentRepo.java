package com.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Entity.Appointment;
import com.Entity.Doctor;
import com.Entity.Patient;


@Repository
public interface IAppointmentRepo extends JpaRepository<Appointment, Integer>{

//	@Query("Select a from Appointment a where a.appointmentId=:s1 OR appointmentDate=:s1 OR appointmentStatus=:s1")
//	List<Appointment> getAppointment(String s1);	

	List<Appointment> getAppointmentByDoctor(Doctor doc);

	
	List<Appointment> getAppointmentByAppointmentDate(String appointmentDate);
}