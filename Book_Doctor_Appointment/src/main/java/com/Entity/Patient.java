package com.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Patient extends User {
	//@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	
	@NotEmpty(message = "Patient Name is required")
	private String patientName;
	
	@NotNull(message = "Mobile Number should not null")
	private String mobileNo;
	
	@NotEmpty(message = "Email is required")
    @Email
	private String email;
	
	
    @NotEmpty(message = "Password is required")
	private String password;
	
	@NotEmpty(message = "blood Group is required")
	private String bloodGroup;
	
	@NotEmpty(message = "Gender is required")
	private String gender;
	
	//@Min(18)
	@NotNull(message = "Age is required")
	private int age;
	
	@NotEmpty(message = "Address is required")
    private String address;
	
	
	@OneToOne(cascade = CascadeType.ALL) 
	Appointment appointment;
	
	public Appointment getAppointment() {
		return appointment;
	}
	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
	
	@OneToOne(cascade = CascadeType.ALL) 
	Feedback feedback;
	
	
	
	
	public Feedback getFeedback() {
		return feedback;
	}
	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
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
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Patient [patientName=" + patientName + ", mobileNo=" + mobileNo + ", email=" + email + ", password="
				+ password + ", bloodGroup=" + bloodGroup + ", gender=" + gender + ", age=" + age + ", address="
				+ address + ", appointment=" + appointment + ", feedback=" + feedback + "]";
	}
	
	
	
	
}
