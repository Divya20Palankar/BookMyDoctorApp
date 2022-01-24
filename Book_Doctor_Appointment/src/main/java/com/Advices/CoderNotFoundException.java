package com.Advices;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class CoderNotFoundException extends Exception
{
	public CoderNotFoundException(String message){
	        super(message);
	    }
}
