package com.example.firstapp.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.firstapp.dto.AddReqDTO;
import com.example.firstapp.dto.AddRespDTO;
import com.example.firstapp.service.Interface.CalculatorService;
@Service
public class CalculatorServiceImpl implements CalculatorService {
	
	private AddRespDTO resp ;
private static final Logger logger = LoggerFactory.getLogger(CalculatorServiceImpl.class);

public  CalculatorServiceImpl(AddRespDTO resp ) {
	 this.resp =resp ;
}
	
    public AddRespDTO addNumbers(AddReqDTO addReq ) {
    	  
    	
    	logger.info("Received request to add numbers addReq: {}",  addReq );
        int sum = addReq.getNum1()+ addReq.getNum2();
        logger.info("Sum calculated: {}", sum);
         
          resp.setSum(sum);
         
         return resp ;
    }

}
