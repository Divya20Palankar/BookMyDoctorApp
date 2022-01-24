package com.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Feedback {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int feedbackId;
	
	@NotNull(message = "Rating is required")
	private int rating;
	
	@NotNull(message = "Feedback details required")
	private String feedback_details;
	
	@OneToOne(cascade = CascadeType.ALL)
	Patient patient;
	
	 @OneToOne(cascade = CascadeType.ALL)
     Doctor doctor;

	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getFeedback_details() {
		return feedback_details;
	}

	public void setFeedback_details(String feedback_details) {
		this.feedback_details = feedback_details;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	@Override
	public String toString() {
		return "Feedback [feedbackId=" + feedbackId + ", rating=" + rating + ", feedback_details=" + feedback_details
				+ ", patient=" + patient + ", doctor=" + doctor + "]";
	}
	 
	 
}
