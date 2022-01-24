package com.Service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.Entity.Patient;
import com.Repository.PatientRepository;

@SpringBootTest
class PatientServiceTest {
	
	@Autowired
	PatientService patientService;
	
	@MockBean
	PatientRepository patientRepository; 

	@Test
	void testAddPatient() {
		Patient p1=new Patient();
		p1.setUserId(1);
		p1.setPatientName("Dhanya");
		p1.setMobileNo("453234267351");
		p1.setEmail("dhanya@gmail.com");
		p1.setPassword("Dhanya@234");
		p1.setBloodGroup("A++");
		p1.setGender("Female");
		p1.setAge(23);
		p1.setAddress("Mangalore");
	    Mockito.when(patientRepository.save(p1)).thenReturn(p1);		
		assertThat(patientService.addPatient(p1)).isEqualTo(p1);
	}

	@Test
	void testEditPatient() throws Throwable {
		Patient p1=new Patient();
		p1.setUserId(1);
		p1.setPatientName("Dhanya");
		p1.setMobileNo("1425368741");
		p1.setEmail("dhanya@gmail.com");
		p1.setPassword("Dhanya@234");
		p1.setBloodGroup("A++");
		p1.setGender("Female");
		p1.setAge(23);
		p1.setAddress("Mangalore");
		
		Optional<Patient> p2=Optional.of(p1);
		
	    Mockito.when(patientRepository.findById(1)).thenReturn(p2);		
	    Mockito.when(patientRepository.save(p1)).thenReturn(p1);	
	    
		p1.setPatientName("Dhanya Suresh");
		p1.setMobileNo("1425");
		p1.setEmail("dhanya123@gmail.com");
		p1.setPassword("Dhanya@234145");
		p1.setBloodGroup("A++");
		p1.setGender("Female");
		p1.setAge(24);
		p1.setAddress("Surathkal");
		
		assertThat(patientService.editPatient(p1)).isEqualTo(p1);

	}
	
	@Test
	void testRemovePatientDetails() {
		Patient p1=new Patient();
		p1.setUserId(1);
		p1.setPatientName("Dhanya");
		p1.setMobileNo("1425368741");
		p1.setEmail("dhanya@gmail.com");
		p1.setPassword("Dhanya@234");
		p1.setBloodGroup("A++");
		p1.setGender("Female");
		p1.setAge(23);
		p1.setAddress("Mangalore");
		
     Optional<Patient> p2=Optional.of(p1);
		
		Mockito.when(patientRepository.findById(1)).thenReturn(p2);
		 Mockito.when(patientRepository.existsById(p1.getUserId())).thenReturn(false);
		   assertFalse(patientRepository.existsById(p1.getUserId()));
	}
	
	@Test
	void testGetAllPatient() {
		Patient p1=new Patient();
		p1.setUserId(1);
		p1.setPatientName("Dhanya");
		p1.setMobileNo("1425368741");
		p1.setEmail("dhanya@gmail.com");
		p1.setPassword("Dhanya@234");
		p1.setBloodGroup("A++");
		p1.setGender("Female");
		p1.setAge(23);
		p1.setAddress("Mangalore");

		
		Patient p2=new Patient();
		p1.setUserId(2);
		p2.setPatientName("Dhanya Suresh");
		p2.setMobileNo("142536");
		p2.setEmail("dhanya11222@gmail.com");
		p2.setPassword("Dhanya54574@234");
		p2.setBloodGroup("B++");
		p2.setGender("Female");
		p2.setAge(25);
		p2.setAddress("Surathkal");
		
		List<Patient> patientList = new ArrayList<>();
		patientList.add(p1);
		patientList.add(p2);
		
		Mockito.when(patientRepository.findAll()).thenReturn(patientList);
		
		assertThat(patientService.getAllPatient()).isEqualTo(patientList);

	}
}
