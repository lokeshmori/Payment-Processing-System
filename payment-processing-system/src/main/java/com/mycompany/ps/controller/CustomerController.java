package com.mycompany.ps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.ps.entity.CustomerOrder;
import com.mycompany.ps.inrfc.CusService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CustomerController {

	 
	@Autowired
	private CusService service ;
	
	
	@PostMapping("/v1/payments")
	public ResponseEntity<CustomerOrder> createOreder(@RequestBody CustomerOrder customerOrder) throws Exception{
		  
		 log.info(" Customer request is recieved:{}",customerOrder);
		 CustomerOrder createdorder = service.createOrder(customerOrder);
		   log.info("Costomer is created : {}",createdorder);
		 return new ResponseEntity<>(createdorder,HttpStatus.CREATED);
		   
	}
	
	
	
	 
	  
}
