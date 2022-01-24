package com.Advices;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class AvailabilityDateNotFoundException extends Exception{
	public AvailabilityDateNotFoundException(String message){
        super(message);
    }
}
