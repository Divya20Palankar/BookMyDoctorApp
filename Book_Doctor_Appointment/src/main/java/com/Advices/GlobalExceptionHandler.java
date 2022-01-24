package com.Advices;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(DoctorNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(DoctorNotFoundException ex, WebRequest request) {
         ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
         return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(AvailabilityDateNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(AvailabilityDateNotFoundException ex, WebRequest request) {
         ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
         return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
	
    @ExceptionHandler(AppointmentException.class)
    public ResponseEntity<?> resourceNotFoundException(AppointmentException ex, WebRequest request) {
         ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
         return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(PatientNotFoudException.class)
    public ResponseEntity<?> resourceNotFoundException(PatientNotFoudException ex, WebRequest request) {
         ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
         return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(UserException.class)
    public ResponseEntity<?> resourceNotFoundException(UserException ex, WebRequest request) {
         ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
         return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(AdminException.class)
    public ResponseEntity<?> resourceNotFoundException(AdminException ex, WebRequest request) {
         ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
         return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
	  @ExceptionHandler(Exception.class) 
	  public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) { ErrorDetails
	  errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(),request.getDescription(false)); 
	  return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR); }
	 
}
