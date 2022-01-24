package com.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Doctor extends User{
	
	//@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	
	@NotBlank(message = "Name is mandatory")
	private String doctorName;
	
	@NotBlank(message = "Speciality is mandatory")
	private String speciality;
	
	@NotBlank(message = "Location is mandatory")
	private String location;
	
	@NotBlank(message = "Hospital Name is mandatory")
	private String hospitalName;
	
	@NotNull(message = "Mobile Number should not null")
	private String mobileNo;
	
	@Email(message = "Write valid email")
	private String email;
	
	@NotNull(message = "Password should not null")
	private String password;
	
	@NotNull(message = "Charged Per Visit should not null")
	private double chargedPerVisit;
	
	@OneToOne(cascade = CascadeType.ALL)
	 Appointment appointment;
	
	public Appointment getAppointment() {
		return appointment;
	}


	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	@OneToOne(cascade = CascadeType.ALL)
	 AvailabilityDates availableDate;
	
	public AvailabilityDates getAvailableDate() {
		return availableDate;
	}


	public void setAvailableDate(AvailabilityDates availableDate) {
		this.availableDate = availableDate;
	}

	@OneToOne(cascade = CascadeType.ALL)
	Feedback feedback;
    
	

	public Feedback getFeedback() {
		return feedback;
	}


	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}


	public String getDoctorName() {
		return doctorName;
	}


	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}


	public String getSpeciality() {
		return speciality;
	}


	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getHospitalName() {
		return hospitalName;
	}


	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}


	public String getMobileNo() {
		return mobileNo;
	}


	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public double getChargedPerVisit() {
		return chargedPerVisit;
	}


	public void setChargedPerVisit(double chargedPerVisit) {
		this.chargedPerVisit = chargedPerVisit;
	}


	@Override
	public String toString() {
		return "Doctor [doctorName=" + doctorName + ", speciality=" + speciality + ", location=" + location
				+ ", hospitalName=" + hospitalName + ", mobileNo=" + mobileNo + ", email=" + email + ", password="
				+ password + ", chargedPerVisit=" + chargedPerVisit + ", appointment=" + appointment
				+ ", availableDate=" + availableDate + ", feedback=" + feedback + "]";
	}



}
