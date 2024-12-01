package com.cpt.payments.service.interfaces;

import com.cpt.payments.dto.PaymentRequestDTO;

public interface Validator {
	
	public void validate(PaymentRequestDTO paymentRequestDTO );
	
	

}
