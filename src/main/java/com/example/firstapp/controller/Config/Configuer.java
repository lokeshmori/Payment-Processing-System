package com.example.firstapp.controller.Config;

import java.util.Random;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.firstapp.dto.AddRespDTO;

@Configuration
public class Configuer {
   
	   @Bean   
		 public Random getRandom() {
			 
			 return new Random() ;
		 }
	     @Bean
	     ModelMapper getModelMapper() {
	    	   return new ModelMapper() ;
	     }
	      @Bean
	     AddRespDTO getAddRespDTO() {
	    	 
	    	  return new AddRespDTO();
	     }
}
