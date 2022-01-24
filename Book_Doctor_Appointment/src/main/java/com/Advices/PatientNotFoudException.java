package com.Advices;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class PatientNotFoudException extends Exception{
	public PatientNotFoudException(String message) {
		super(message);
	}
}
