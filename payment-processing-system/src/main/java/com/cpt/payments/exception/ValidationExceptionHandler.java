package com.cpt.payments.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cpt.payments.constant.ErrorCodeEnum;
import com.cpt.payments.pojo.PaymentError;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class ValidationExceptionHandler {

	 @ExceptionHandler(ValidationException.class)
	 public ResponseEntity<PaymentError>handleCustomUncheckedException(ValidationException ex){
		 
		         PaymentError paymentError = new PaymentError(ex.getErrorCode(), ex.getErrorMassage());
		         
		 log.error("Error occured :{}",paymentError);
		   return new ResponseEntity<>(paymentError ,ex.getHttpStatus());
		   
	 }
	 
	 
	 
	 @ExceptionHandler(Exception.class)
	 public ResponseEntity<PaymentError>handleGenricException(Exception ex){
		 
		         PaymentError paymentError = new PaymentError(ErrorCodeEnum.GENERIC_ERROR.getErrorCode(),ErrorCodeEnum.GENERIC_ERROR.getErrorMassage());
		         
		 log.error("Error occured :{}",paymentError);
		   return new ResponseEntity<>(paymentError ,HttpStatus.INTERNAL_SERVER_ERROR);
		   
	 }
	 
	  
}
