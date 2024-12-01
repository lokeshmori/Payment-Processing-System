package com.cpt.payments.dto;

import lombok.Data;

@Data
public class PaymentResponseDTO {

	  String txnId ;
	  String redirectUrl ;
	  
	 public PaymentResponseDTO( String txnId ,
	  String redirectUrl ){
		   
		   this.txnId = txnId ;
		   this.redirectUrl = redirectUrl ;
	  }
	  
	  	    
}
