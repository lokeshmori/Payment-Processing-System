package com.example.firstapp.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.firstapp.pojo.AddReq;
import com.example.firstapp.service.Interface.CalculatorService;
@Service
public class CalculatorServiceImpl implements CalculatorService {
	
	      
private static final Logger logger = LoggerFactory.getLogger(CalculatorServiceImpl.class);
	
    public int addNumbers(AddReq addReq ) {
    	logger.info("Received request to add numbers addReq: {}",  addReq );
        int sum = addReq.getNum1()+ addReq.getNum2();
        logger.info("Sum calculated: {}", sum);
        return sum;
    }

}
