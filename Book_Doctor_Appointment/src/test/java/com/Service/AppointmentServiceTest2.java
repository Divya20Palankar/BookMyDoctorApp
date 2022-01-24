package com.Service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.Entity.Appointment;
import com.Repository.IAppointmentRepo;


@SpringBootTest
class AppointmentServiceTest2 {
	@Autowired
	AppointmentService appointmentservice;
	
	@MockBean
	IAppointmentRepo repo;

	@Test
	void testAddAppointment() {
		Appointment a1=new Appointment();
		a1.setAppointmentId(1);
		a1.setAppointmentDate("22/1/2022");
		a1.setAppointmentStatus("completed");
	    Mockito.when(repo.save(a1)).thenReturn(a1);		
		assertThat(appointmentservice.addAppointment(a1)).isEqualTo(a1);
	}

}
