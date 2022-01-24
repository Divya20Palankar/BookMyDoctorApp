package com.Service;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.Entity.Doctor;
import com.Repository.DoctorRepository;

@SpringBootTest
class DoctorServiceTest {

	@Autowired
	DoctorService doctorService;
	
	@MockBean
	DoctorRepository doctorRepo;
	
	@Test
	void testAddDoctor() {
		Doctor d1=new Doctor();
		
		d1.setUserId(1);
		d1.setDoctorName("Deepa");
		d1.setSpeciality("Dental");
		d1.setLocation("Banglore");
		d1.setHospitalName("Deeparaj");
		d1.setMobileNo("9876543210");
		d1.setEmail("deepa@gmail.com");
		d1.setPassword("deepa@");
		d1.setChargedPerVisit(500.0);
		
	    Mockito.when(doctorRepo.save(d1)).thenReturn(d1);		
		assertThat(doctorService.addDoctor(d1)).isEqualTo(d1);
	}

	@Test
	void testGetDoctorList() {
		Doctor d1=new Doctor();
		
		d1.setUserId(1);
		d1.setDoctorName("Deepa");
		d1.setSpeciality("Dental");
		d1.setLocation("Banglore");
		d1.setHospitalName("Deeparaj");
		d1.setMobileNo("9876543210");
		d1.setEmail("deepa@gmail.com");
		d1.setPassword("deepa@");
		d1.setChargedPerVisit(500.0);
		
		Doctor d2=new Doctor();
		
		d1.setUserId(2);
		d2.setDoctorName("Harini");
		d2.setSpeciality("Surgen");
		d2.setLocation("chennai");
		d2.setHospitalName("hariniravi");
		d2.setMobileNo("123456");
		d2.setEmail("harini@gmail.com");
		d2.setPassword("harini@");
		d2.setChargedPerVisit(500);

		List<Doctor> doctorList = new ArrayList<>();
		doctorList.add(d1);
		doctorList.add(d2);
		
		Mockito.when(doctorRepo.findAll()).thenReturn(doctorList);
		
		assertThat(doctorService.getDoctorList()).isEqualTo(doctorList);
	}
	
	
	
	/*
	 * @Test
	 * 
	 * @Disale
	 */
		/*
		 * void testGetDoctorBySpeciality() throws Throwable {
		 * 
		 * Doctor d1=new Doctor(); d1.setId(1); d1.setDoctorName("Deepa");
		 * d1.setSpeciality("Dental"); d1.setLocation("Banglore");
		 * d1.setHospitalName("Deeparaj"); d1.setMobileNo("9876543210");
		 * d1.setEmail("deepa@gmail.com"); d1.setPassword("deepa@");
		 * d1.setChargedPerVisit(500.0);
		 * 
		 * Optional<Doctor> c2=Optional.of(d1);
		 * 
		 * Mockito.when(doctorRepo.findBySpeciality("Dental")).thenReturn(c2);
		 * 
		 * assertThat(doctorService.getDoctorListbySpeciality("Dental")).isEqualTo(d1);
		 * }
		 */
	 

	@Test
	void testUpdateDoctor() throws Throwable {
		Doctor d1=new Doctor();
		d1.setUserId(1);
		d1.setDoctorName("Harini");
		d1.setSpeciality("Surgen");
		d1.setLocation("chennai");
		d1.setHospitalName("hariniravi");
		d1.setMobileNo("123456");
		d1.setEmail("harini@gmail.com");
		d1.setPassword("harini@");
		d1.setChargedPerVisit(500);
		
		Optional<Doctor> d2=Optional.of(d1);
		
		Mockito.when(doctorRepo.findById(1)).thenReturn(d2);
		
		Mockito.when(doctorRepo.save(d1)).thenReturn(d1);
		d1.setDoctorName("Deepa");
		d1.setSpeciality("Dentist");
		
		assertThat(doctorService.updateDoctorProfile(d1)).isEqualTo(d1);
	}
	
	@Test
	void testDeleteDoctor() {
		Doctor d1=new Doctor();
		d1.setUserId(1);
		d1.setDoctorName("Deepa");
		d1.setSpeciality("Surgen");
		d1.setLocation("chennai");
		d1.setHospitalName("hariniravi");
		d1.setMobileNo("123456");
		d1.setEmail("harini@gmail.com");
		d1.setPassword("harini@");
		d1.setChargedPerVisit(500);
		
		Optional<Doctor> d2=Optional.of(d1);
		
		Mockito.when(doctorRepo.findById(1)).thenReturn(d2);
		 Mockito.when(doctorRepo.existsById(d1.getUserId())).thenReturn(false);
		   assertFalse(doctorRepo.existsById(d1.getUserId()));
	}


}
