package com.cpt.payments.service.impl.validators;

import org.springframework.stereotype.Service;

import com.cpt.payments.dto.PaymentRequestDTO;
import com.cpt.payments.service.interfaces.Validator;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class ValidatorRule2 implements Validator {

	public void validate(PaymentRequestDTO paymentRequestDTO ) {
		
		log.info("Validator2 : Payment service request :{}",paymentRequestDTO);
	 }
	
}
