package com.cpt.payments.service.interfaces;

import com.cpt.payments.dto.PaymentRequestDTO;
import com.cpt.payments.dto.PaymentResponseDTO;

public interface PaymentService {

	public  PaymentResponseDTO validateAndProcessPayment(PaymentRequestDTO paymentRequestDto ) ;
}