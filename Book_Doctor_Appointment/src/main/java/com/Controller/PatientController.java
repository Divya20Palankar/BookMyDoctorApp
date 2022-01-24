package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Entity.Patient;
import com.Service.PatientService;

@RestController
@RequestMapping(path="/api")
@CrossOrigin
public class PatientController {

	@Autowired
	PatientService patientService;
	
	@PostMapping("/addPatient")
	public ResponseEntity<Patient> addPatient(@RequestBody Patient p) {
      Patient p1=patientService.addPatient(p);
		ResponseEntity re=new ResponseEntity<Patient>(p1,HttpStatus.OK);
		return re;
	}
	
	@PutMapping(path="/updatePatient")
	public ResponseEntity<Patient> updatePatient(@RequestBody Patient p) throws Throwable
	{
		Patient p1=patientService.editPatient(p);
		ResponseEntity re=new ResponseEntity<Patient>(p1,HttpStatus.OK);
		return re;
	}
	
	@DeleteMapping(path="/deletePatient")
	public ResponseEntity<String> deletePatient(@RequestBody Patient p)
	{
		patientService.removePatientDetails(p);
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
	

	
	@GetMapping(path="/getPatients")
	public ResponseEntity<List<Patient>> getPatients()
	{
		List<Patient> lc=patientService.getAllPatient();
		ResponseEntity re=new ResponseEntity<List<Patient>>(lc,HttpStatus.OK);
		return re;
	}
	@DeleteMapping(path="/deletePatient/{userId}")
	public ResponseEntity<String> deletePatientById(@PathVariable int userId)
	{
		patientService.deletePatById(userId);
		
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
	
	@GetMapping(path="/getPatient/{userId}")
	public ResponseEntity<Patient> getPatById(@PathVariable int userId) throws Exception
	{
		Patient e1=patientService.getPatById(userId);
		
		ResponseEntity re=new ResponseEntity<Patient>(e1,HttpStatus.OK);
		return re;
	}
	
	/*
	 * @GetMapping(path="/getPatient/{s1}") public ResponseEntity<List<Patient>>
	 * getPatient(@PathVariable String s1) { List<Patient>
	 * lc=patientService.getPatient(s1); ResponseEntity re=new
	 * ResponseEntity<List<Patient>>(lc,HttpStatus.OK); return re; }
	 */
	
}
