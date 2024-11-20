package com.example.firstapp.controller.Config;

import java.util.Random;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configuer {
   
	   @Bean   
		 public Random getRandom() {
			 
			 return new Random() ;
		 }
	  
	
}
