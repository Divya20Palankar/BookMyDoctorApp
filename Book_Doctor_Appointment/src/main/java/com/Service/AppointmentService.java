package com.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Advices.AppointmentException;
import com.Entity.Appointment;
import com.Entity.Doctor;
import com.Entity.Patient;
import com.Repository.IAppointmentRepo;

@Service
public class AppointmentService  {
	
	
	@Autowired
	IAppointmentRepo repo;
	
	public List<Appointment> addAppointments(List<Appointment> ls) {
		repo.saveAll(ls);
		return ls;
	}
	
	public Appointment addAppointment(Appointment c)
	{
		repo.save(c);
		return c;	
	}
	
	

	
	public List<Appointment> getAllAppointments() {
		List<Appointment> ls=repo.findAll();
		return ls;
	}


	public Appointment getAppointment(int appointmentId) {
		
		Appointment a=repo.findById(appointmentId).orElseThrow();
		Supplier s1= ()->new AppointmentException("Appointment Does not exist in the database");

		return a;
	}

	
	public String deleteAppointment(int appointmentId) {
		repo.deleteById(appointmentId);
		
		return "Deleted";
	}

	
	public Appointment updateAppointment(Appointment bean) throws Throwable {
		int id=bean.getAppointmentId();
		Supplier s1= ()->new AppointmentException("Appointment Id Does not exist in the database");
		Appointment a1=repo.findById(id).orElseThrow();
		
		a1.setAppointmentDate(bean.getAppointmentDate());
			a1.setAppointmentStatus(bean.getAppointmentStatus());
			a1.setDoctor(a1.getDoctor());
			a1.setPatient(a1.getPatient());
			repo.save(a1);
			return a1;	
	}


	public List<Appointment> getAppointments(Doctor doc) {
		List<Appointment> ls=repo.getAppointmentByDoctor(doc);
		return ls;
	}

	
	public List<Appointment> getAppointments(String appointmentDate) {
		List<Appointment> ls=repo.getAppointmentByAppointmentDate(appointmentDate);
		return ls;
	}


}
