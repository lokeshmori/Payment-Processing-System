package com.cpt.payments.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdditionController {
	
	          
	    
    @PostMapping("/add")
    public int add(@RequestParam int num1, @RequestParam int num2) {
        System.out.println("num1:" + num1 + "|num2:" + num2);
    	
        int sumResult = num1 + num2;
        System.out.println("sumResult:" + sumResult);

        return sumResult;
    }
    
     
}
