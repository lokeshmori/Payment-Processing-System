package com.cpt.payments.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.cpt.payments.constant.ValidatorEnum;
import com.cpt.payments.dto.PaymentRequestDTO;
import com.cpt.payments.dto.PaymentResponseDTO;
import com.cpt.payments.service.interfaces.PaymentService;
import com.cpt.payments.service.interfaces.Validator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {

	@Value("${validator.rules}")
	
	private String validatorRules ; 
	ApplicationContext applicationContext ;
	// PaymentResponseDTO paymentResponseDto ;
	
	          public PaymentServiceImpl(ApplicationContext applicationContext) {
				// TODO Auto-generated constructor stub
	        	  
	        	     this.applicationContext =applicationContext ;
			}
	    
	              
	            
	              
	          
	    public  PaymentResponseDTO validateAndProcessPayment(PaymentRequestDTO paymentRequestDto ) {
	    	
	    	  log.info("service is received DTO :{} ",paymentRequestDto);
	    	  
	    	 // String str = null ;
	    	 // str.length() ;
	    	  
	    	  String rules[] = validatorRules.split(",");
	    	  
	    	  for(String rule: rules) {
	    		  triggerValidationRule(paymentRequestDto, rule); 
	    		  	
	    	  }
	    	  
	    	  String txnId = "TX123";
	    		 String redirectUrl = "http://www.google.com" ;
	    		 
	    		   PaymentResponseDTO paymentResponseDto = new PaymentResponseDTO(txnId,redirectUrl);
	    	            log.info("payment response : {}", paymentResponseDto);
	    	                  return paymentResponseDto ;
	    	 
	    	 }

		String triggerValidationRule(PaymentRequestDTO paymentRequestDto, String rule) {
			rule = rule.trim();
			  Validator validator  = null ;
			  log.info("service is received for rule : {} ",rule);
			  Class<? extends Validator> validatorClass = ValidatorEnum.getClassByName(rule); 
			     
			  validator = applicationContext.getBean(validatorClass);
			 
			    	   if(validatorClass != null) {
			    		   
			    	   validator = applicationContext.getBean(validatorClass);
			    	   log.info("Validatorclass  :{}",validatorClass);
			    	          if(validator != null) {
			    	        	    
			    	        	  validator.validate(paymentRequestDto);
			    	        	  log.info("Validator rules methods are called :{}",paymentRequestDto);
			    	          }
			    	   }
			      
			      if(validator == null  || validatorClass ==null) {
			    	  
			    	  log.error("ValidatorClass not found for :{} | Validator Rule not found for :{}", rule ,validator);
			    	  
			    	  // continue ;
			    	     
			      }
			return rule;
		}
}
