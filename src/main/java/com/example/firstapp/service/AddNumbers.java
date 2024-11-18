package com.example.firstapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.firstapp.pojo.AddReq;
@Service
public class AddNumbers {
	
	      
private static final Logger logger = LoggerFactory.getLogger(AddNumbers.class);
	
    public int addNumbers(AddReq addReq ) {
    	logger.info("Received request to add numbers addReq: {}",  addReq );
        int sum = addReq.getNum1()+ addReq.getNum2();
        logger.info("Sum calculated: {}", sum);
        return sum;
    }

}
