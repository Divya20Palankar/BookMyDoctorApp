package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Entity.Doctor;
import com.Entity.Patient;
import com.Service.DoctorService;

//@Controller
@RestController
@RequestMapping(path="/doc")
@CrossOrigin
public class DoctorController {
	
	@Autowired
	DoctorService doctorService;

	@PostMapping("/addDoctor")
	@ResponseBody
	public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor d)
	{
		Doctor d1=doctorService.addDoctor(d);
		ResponseEntity re=new ResponseEntity<Doctor>(d1,HttpStatus.OK);
		return re;
	}

	@GetMapping("/getDoctorList")
	public ResponseEntity<List<Doctor>> getDoctorList(Doctor d) {
		List<Doctor> d2=doctorService.getDoctorList();
		ResponseEntity re=new ResponseEntity<List<Doctor>>(d2,HttpStatus.OK);
		return re;
	}
	
	@GetMapping("/getDoctorsList/{speciality}")
	public <getDoctorListbySpeciality> ResponseEntity<Doctor> getDoctorListbySpeciality(@PathVariable String speciality) throws Throwable {
		List<Doctor> d3=doctorService.getDoctorListbySpeciality(speciality);
		ResponseEntity re=new ResponseEntity<Doctor>(HttpStatus.OK);
		return re;
	}
	
	@PutMapping(path="/updateDoctorProfile")
	public ResponseEntity<Doctor> updateDoctorProfile(@RequestBody Doctor d) throws Throwable
	{
		Doctor d4=doctorService.updateDoctorProfile(d);
		ResponseEntity re=new ResponseEntity<Doctor>(d4,HttpStatus.OK);
		return re;
	}
	
	@DeleteMapping(path="/removeDoctor/{doctorId}")
	public ResponseEntity<String> removeDoctorById(@PathVariable int doctorId)
	{
		String d5=doctorService.removeDoctorById(doctorId);
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
	@GetMapping(path="/getDoctor/{userId}")
	public ResponseEntity<Doctor> getDoctorById(@PathVariable int userId) throws Exception
	{
		Doctor e1=doctorService.getDoctorById(userId);
		
		ResponseEntity re=new ResponseEntity<Doctor>(e1,HttpStatus.OK);
		return re;
	}

}
