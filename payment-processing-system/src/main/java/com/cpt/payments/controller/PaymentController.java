package com.cpt.payments.controller;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cpt.payments.constant.Endpoints;
import com.cpt.payments.dto.PaymentRequestDTO;
import com.cpt.payments.dto.PaymentResponseDTO;
import com.cpt.payments.pojo.PaymentRequest;
import com.cpt.payments.pojo.PaymentResponse;
import com.cpt.payments.service.interfaces.PaymentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(Endpoints.V1_PAYMENTS)
@Slf4j
public class PaymentController {

	               PaymentService paymentService ;
	               ModelMapper modelMapper ;
	               
	               
	               public PaymentController(PaymentService paymentService , ModelMapper modelMapper) {
					
	            	        this.paymentService = paymentService ;
	            	        this.modelMapper =modelMapper ;
				}
	 

	@PostMapping
     public  ResponseEntity<PaymentResponse> createPayment(@RequestBody PaymentRequest payReq) {
   	  
   	       log.info(" Payment request recieved : {} ", payReq);
   	  
   	    PaymentRequestDTO payReqDto =  modelMapper.map(payReq, PaymentRequestDTO.class);
   	    
   	 PaymentResponseDTO paymentResponseDto = paymentService.validateAndProcessPayment(payReqDto);
   	             
   	                    PaymentResponse paymentResponse = modelMapper.map(paymentResponseDto, PaymentResponse.class);
   	            
   	           return new ResponseEntity<>(paymentResponse ,HttpStatus.CREATED);
     }
	   
}
