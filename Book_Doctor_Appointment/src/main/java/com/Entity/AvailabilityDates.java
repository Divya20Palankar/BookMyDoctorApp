package com.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

@Entity
public class AvailabilityDates {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int availabilityDatesId;
	
	@NotEmpty(message = "From Date is required")
	private String fromDate;
	
	@NotEmpty(message = "End Date is required")
	private String endDate;

	@OneToOne(cascade = CascadeType.ALL)
	 Doctor doctor;
	
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public int getAvailabilityDatesId() {
		return availabilityDatesId;
	}
	public void setAvailabilityDatesId(int availabilityDatesId) {
		this.availabilityDatesId = availabilityDatesId;
	}
	
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "AvailabilityDates [availabilityDatesId=" + availabilityDatesId + ", fromDate=" + fromDate + ", endDate=" + endDate + ", doctor=" + doctor
				+ "]";
	}
	
	

	
}
