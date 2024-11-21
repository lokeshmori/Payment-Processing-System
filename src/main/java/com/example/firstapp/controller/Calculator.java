package com.example.firstapp.controller;

import java.util.Random;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.firstapp.dto.AddReqDTO;
import com.example.firstapp.dto.AddRespDTO;
import com.example.firstapp.pojo.AddReq;
import com.example.firstapp.pojo.AddResp;
import com.example.firstapp.service.Interface.CalculatorService;
import com.google.gson.Gson;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class Calculator {
	
	    private ModelMapper modelMaper ;
	    private CalculatorService obj ;
	    private ApplicationContext ap ;
	    private Random random ;
	   private  Gson gson ;
	   
	   @Value("${mytestkey}")
	   private String myTestKey ;
	   
	private static final Logger logger = LoggerFactory.getLogger(Calculator.class);
	
	             public Calculator(ApplicationContext ap , CalculatorService obj ,ModelMapper modelMapper) {
	            	       this.ap = ap ;
	            	       this.obj =obj ;
	            	       this.modelMaper =modelMapper ;
	            	       
//	            	      String [] beanNames = ap.getBeanDefinitionNames();
//	            	      
//	            	      for(String beanName : beanNames) {
//	            	    	  
//	            	    	  logger.info(" Bean Name :{}" ,beanName);
//	            	    	  log.info(" Bean Name :{}" ,beanName);
//	            	    	    
//	            	      }
					
	            	 
	            	// this.obj = obj ;
				}
	             
	             @PostConstruct
	             public void init() {
	            	 log.info(" Calculator bean created : {}",myTestKey);
	             }
	  
    @GetMapping("/add") 
    public AddResp addNumbers(@RequestBody AddReq addReq ) {
    	logger.info("Received request to add numbers addReq: {}",  addReq );
    	
    	// AddNumbers obj = new AddNumbers();
    	 log.info(myTestKey);
    	
    	      
    	
    	   obj = ap.getBean(CalculatorService.class);
    	       gson = ap.getBean(Gson.class);
    	       String str =  gson.toJson(addReq);
    	       logger.info("obj to string convert : {}", str );
    	                      AddReqDTO reqDto  = modelMaper.map(addReq,AddReqDTO.class );
    	  AddRespDTO sum = obj.addNumbers(reqDto);
       // logger.info("Sum retured after calculation: {}", sum );
        log.info("Sum retured after calculation: {}", sum );
        
           random = ap.getBean(Random.class);
           
        logger.info("Random Number:{}",random.nextInt(100));
        
                 AddResp resp = modelMaper.map(sum, AddResp.class);
             return resp;
    }
}