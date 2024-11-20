package com.example.firstapp.controller;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.firstapp.pojo.AddReq;
import com.example.firstapp.service.AddNumbers;
import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class Calculator {
	
	
	    private AddNumbers obj ;
	    private ApplicationContext ap ;
	    private Random random ;
	   private  Gson gson ;
	private static final Logger logger = LoggerFactory.getLogger(Calculator.class);
	
	             public Calculator(ApplicationContext ap) {
	            	       this.ap = ap ;
	            	       
//	            	      String [] beanNames = ap.getBeanDefinitionNames();
//	            	      
//	            	      for(String beanName : beanNames) {
//	            	    	  
//	            	    	  logger.info(" Bean Name :{}" ,beanName);
//	            	    	  log.info(" Bean Name :{}" ,beanName);
//	            	    	    
//	            	      }
//					
	            	 
	            	// this.obj = obj ;
				}
	  
    @GetMapping("/add") 
    public int addNumbers(@RequestBody AddReq addReq ) {
    	logger.info("Received request to add numbers addReq: {}",  addReq );
    	
    	// AddNumbers obj = new AddNumbers();
    	
    	      
    	
    	   obj = ap.getBean(AddNumbers.class);
    	       gson = ap.getBean(Gson.class);
    	       String str =  gson.toJson(addReq);
    	       logger.info("obj to string convert : {}", str );
    	   int sum = obj.addNumbers(addReq);
       // logger.info("Sum retured after calculation: {}", sum );
        log.info("Sum retured after calculation: {}", sum );
        
           random = ap.getBean(Random.class);
           
        logger.info("Random Number:{}",random.nextInt(100));
        return sum;
    }
}