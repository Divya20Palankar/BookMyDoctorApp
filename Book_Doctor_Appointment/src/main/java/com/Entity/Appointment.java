package com.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

@Entity
public class Appointment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int appointmentId;
	
	@NotEmpty(message = "Appointment Date is required")
	private String appointmentDate;
	
	@NotEmpty(message = "Appointment Status is required")
	private String appointmentStatus;
	
	
    @OneToOne(cascade = CascadeType.ALL)
	Doctor doctor;
	
	@OneToOne(cascade = CascadeType.ALL)
	Patient patient;
	
		
	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", doctor=" + doctor + ", patient=" + patient
				+ ", appointmentDate=" + appointmentDate + ", appointmentStatus=" + appointmentStatus + "]";
	}
	
	public int getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public String getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public String getAppointmentStatus() {
		return appointmentStatus;
	}
	public void setAppointmentStatus(String appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
	}
	
	
}
