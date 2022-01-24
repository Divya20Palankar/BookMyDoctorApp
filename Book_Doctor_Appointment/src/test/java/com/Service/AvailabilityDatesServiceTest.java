package com.Service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.Entity.Doctor;
import com.Repository.AvailabilityDatesRepository;
import com.Repository.DoctorRepository;

class AvailabilityDatesServiceTest {

	@Autowired
	AvailabilityDatesService availabilityService;
	
	@MockBean
	AvailabilityDatesRepository availablityRepo;


}
