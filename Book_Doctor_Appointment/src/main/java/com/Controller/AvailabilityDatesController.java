package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Entity.AvailabilityDates;
import com.Entity.Doctor;
import com.Service.AvailabilityDatesService;
import com.Service.DoctorService;

//@Controller
@RestController
@RequestMapping(path="/availableDate")
public class AvailabilityDatesController {

	@Autowired
	AvailabilityDatesService availabilityService;

	@PostMapping("/addAvailability")
	//@ResponseBody
	public ResponseEntity<AvailabilityDates> availabilityDates(@RequestBody AvailabilityDates ad)
	{
		AvailabilityDates ad1=availabilityService.addAvailabilityDates(ad);
		ResponseEntity re=new ResponseEntity<AvailabilityDates>(ad1,HttpStatus.OK);
		return re;
	}
	
	@PutMapping(path="/updateAvailability")
	public ResponseEntity<AvailabilityDates> updateAvailabilityDates(@RequestBody AvailabilityDates ad) throws Throwable
	{
		AvailabilityDates ad2=availabilityService.updateAvailabilityDates(ad);
		ResponseEntity re=new ResponseEntity<AvailabilityDates>(ad2,HttpStatus.OK);
		return re;
	}
}
