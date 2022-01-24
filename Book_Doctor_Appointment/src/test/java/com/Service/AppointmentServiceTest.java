package com.Service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.Entity.Appointment;
import com.Repository.IAppointmentRepo;

@SpringBootTest
class AppointmentServiceTest {
	
	@Autowired
	AppointmentService appointmentservice;
	
	@MockBean
	IAppointmentRepo repo; 

	@Test
	void testGetAllAppointments() {
		Appointment a=new Appointment();
		a.setAppointmentId(1);
		a.setAppointmentDate("22/2/2022");
		a.setAppointmentStatus("pending");
		
		Appointment a2=new Appointment();
		a2.setAppointmentId(2);
		a2.setAppointmentDate("22/1/2022");
		a2.setAppointmentStatus("completed");
		
		List<Appointment> appointmetList = new ArrayList<>();
		appointmetList.add(a);
		appointmetList.add(a2);
		
		Mockito.when(repo.findAll()).thenReturn(appointmetList);
		
		assertThat(appointmentservice.getAllAppointments()).isEqualTo(appointmetList);
		
	}

	@Test
	void testGetAppointment() {
		Appointment a=new Appointment();
		a.setAppointmentId(1);
		a.setAppointmentDate("22/2/2022");
		a.setAppointmentStatus("pending");

		Optional<Appointment> c2=Optional.of(a);
		
		Mockito.when(repo.findById(1)).thenReturn(c2);
		
		assertThat(appointmentservice.getAppointment(1)).isEqualTo(a);
	}
	

	@Test
	void testDeleteAppointment() {
		Appointment c1=new Appointment();
		c1.setAppointmentId(1);;
		c1.setAppointmentDate("22/02/2022");
		c1.setAppointmentStatus("pending") ;
		Optional<Appointment> c2=Optional.of(c1);
		
		Mockito.when(repo.findById(1)).thenReturn(c2);
		 Mockito.when(repo.existsById(c1.getAppointmentId())).thenReturn(false);
		   assertFalse(repo.existsById(c1.getAppointmentId()));
	}

	@Test
	boolean testUpdateAppointment() throws Throwable {
		Appointment c1=new Appointment();
		c1.setAppointmentId(1);
		c1.setAppointmentDate("22/02/2022");
		c1.setAppointmentStatus("pending") ;
		//c1.setDoctor(null);
		//c1.setPatient(null);
		Optional<Appointment> c2=Optional.of(c1);
		
		Mockito.when(repo.findById(1)).thenReturn(c2);
		
		Mockito.when(repo.save(c1)).thenReturn(c1);
		c1.setAppointmentDate("22/01/2021");
		c1.setAppointmentStatus("completed");
		//c1.setDoctor(null);
		//c1.setPatient(null);
		
		assertThat(appointmentservice.updateAppointment(c1)).isEqualTo(c1);
		return true;
	}
	

	
	
	
//	@Test
//	void testGetAppointmentsDoctor() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetAppointmentsString() {
//		fail("Not yet implemented");
//	}

}

