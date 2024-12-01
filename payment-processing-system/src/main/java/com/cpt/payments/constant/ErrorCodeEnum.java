package com.cpt.payments.constant;

public enum ErrorCodeEnum {

	
	 GENERIC_ERROR("500","Unable to process request, please try again later"),
	 INVALID_AMOUNT("400", "Amount cannot be negative, please correct the amount and try again") ;
	
	  private String errorCode ;
	  private String errorMassage ;
	  
	  
	private ErrorCodeEnum(String errorCode, String errorMassage) {
		this.errorCode = errorCode;
		this.errorMassage = errorMassage;
	}


	public String getErrorCode() {
		return errorCode;
	}


	public String getErrorMassage() {
		return errorMassage;
	}


	  
	   
}
