package com.Advices;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class AppointmentException extends Exception{
	public AppointmentException(String message) {
		super(message);
	}

}
