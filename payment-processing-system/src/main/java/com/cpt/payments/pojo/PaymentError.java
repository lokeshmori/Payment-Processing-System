package com.cpt.payments.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PaymentError {

	 private String errorCode ;
	  private String errorMassage ;
	  
	  
	public PaymentError(String errorCode, String errorMassage) {
	//	super();
		this.errorCode = errorCode;
		this.errorMassage = errorMassage;
	}
	  
	  
}
