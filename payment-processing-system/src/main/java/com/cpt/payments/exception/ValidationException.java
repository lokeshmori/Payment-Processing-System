package com.cpt.payments.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ValidationException extends RuntimeException {

	
	private static final long serialVersionUID = 4289409051253111135L;

	  private String errorCode ;
	  private String errorMassage ;
	  private  HttpStatus  httpStatus ;
	  
	public ValidationException(String errorCode, String errorMassage , HttpStatus httpStatus) {
		super(errorMassage);
		this.errorCode = errorCode;
		this.errorMassage = errorMassage;
		this.httpStatus = httpStatus ;
	}
	  
	
	
	 
}
