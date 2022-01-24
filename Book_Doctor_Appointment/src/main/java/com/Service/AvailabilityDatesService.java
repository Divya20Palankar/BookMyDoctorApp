package com.Service;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Advices.DoctorNotFoundException;
import com.Entity.AvailabilityDates;
import com.Entity.Doctor;
import com.Repository.AvailabilityDatesRepository;
import com.Repository.DoctorRepository;

@Service
public class AvailabilityDatesService {

	@Autowired
	AvailabilityDatesRepository availablityRepo;

	public AvailabilityDates addAvailabilityDates(AvailabilityDates ad) {
		availablityRepo.save(ad);
		return ad;
	}

	public AvailabilityDates updateAvailabilityDates(AvailabilityDates ad) throws Throwable {
		int id=ad.getAvailabilityDatesId();
		Supplier s1= ()->new DoctorNotFoundException("Availability date Does not exist in the database");
		AvailabilityDates ad1=availablityRepo.findById(id).orElseThrow();

		ad1.setFromDate(ad.getFromDate());
		ad1.setEndDate(ad.getEndDate());
		ad1.setDoctor(ad.getDoctor());

		availablityRepo.save(ad1);
		return ad1;	
	}

}
