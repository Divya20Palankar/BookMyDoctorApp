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

import com.Entity.Appointment;

import com.Service.AppointmentService;

@RestController
@RequestMapping(path="/api")
@CrossOrigin
public class AppointmentController {
	
	
	@Autowired
	AppointmentService appointmentservice;
	
	
	
	@PostMapping("/addAppointments")
	public ResponseEntity<List<Appointment>> addAppointments(@RequestBody List<Appointment> c)
	{
		List<Appointment> c1=appointmentservice.addAppointments(c);
		ResponseEntity re=new ResponseEntity<List<Appointment>>(c1,HttpStatus.OK);
		return re;
	}
	
	@PostMapping("/addAppointment")
	public ResponseEntity<Appointment> addAppointment(@RequestBody Appointment c)
	{
		Appointment c1=appointmentservice.addAppointment(c);
		ResponseEntity re=new ResponseEntity<Appointment>(c1,HttpStatus.OK);
		return re;
	}
	
	
	@GetMapping(path="/getAllAppointment")
	public ResponseEntity<List<Appointment>> getAllAppointment()
	{
		List<Appointment> lc=appointmentservice.getAllAppointments();
		ResponseEntity re=new ResponseEntity<List<Appointment>>(lc,HttpStatus.OK);
		return re;
	}
	
	@GetMapping(path="/getAppointment/{appointmentId}")
	public ResponseEntity<Appointment> getAppointment(@PathVariable int appointmentId) {
		Appointment a=appointmentservice.getAppointment(appointmentId);
		ResponseEntity re=new ResponseEntity<Appointment>(a,HttpStatus.OK);
		return re;
	}
	
	
	@DeleteMapping(path="/deleteAppointment/{appointmentId}")
	public ResponseEntity<String> deleteAppointment(@PathVariable int appointmentId) {
		
	appointmentservice.deleteAppointment(appointmentId);
	ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
	return re;
	}
	
	@PutMapping(path="/updateAppointment")
	public ResponseEntity<Appointment> updateAppointment(@RequestBody Appointment bean) throws Throwable {
		Appointment a=appointmentservice.updateAppointment(bean);
		ResponseEntity re=new ResponseEntity<Appointment>(a,HttpStatus.OK);
		return re;
	}
	
	
	
}
