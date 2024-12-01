package com.cpt.payments.service.impl.validators;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.cpt.payments.constant.ErrorCodeEnum;
import com.cpt.payments.dto.PaymentRequestDTO;
import com.cpt.payments.exception.ValidationException;
import com.cpt.payments.service.interfaces.Validator;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class ValidatorRule1 implements Validator{

	
	public void validate(PaymentRequestDTO paymentRequestDTO ) {
		
		
		
		log.info("Validator1 : Payment service request :{}",paymentRequestDTO);
		 
		if(paymentRequestDTO.getAmount() <0) {
			
			     
			 log.error("eror occured amount can not be nagative");
			throw new ValidationException(ErrorCodeEnum.INVALID_AMOUNT.getErrorCode(),ErrorCodeEnum.INVALID_AMOUNT.getErrorMassage(),HttpStatus.BAD_REQUEST) ;
		}
		 
	 }
	   
	  
}
