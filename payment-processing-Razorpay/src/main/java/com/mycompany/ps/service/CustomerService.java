package com.mycompany.ps.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mycompany.ps.entity.CustomerOrder;
import com.mycompany.ps.inrfc.CusService;
import com.mycompany.ps.repo.CustomerOrderRepo;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerService implements CusService {

	       @Autowired
	    private CustomerOrderRepo customerRepo ;
	    
	         
	       @Value("${razorpay.key.id}")
	       private String razorPayKey ;
	       @Value("${razorpay.secret.key}")
	       private String razorPaySecret ;
	       
	       private RazorpayClient  client ; 
	       
	       public  CustomerOrder createOrder(CustomerOrder cusOrder) throws Exception  {
	    	   
	    	     
    	    JSONObject orderReq = new JSONObject();
    	       log.info("json object is created : {}",orderReq);
    	      orderReq.put("amount", cusOrder.getAmount()*100);
    	      orderReq.put("currency", "INR");
	    	      
	    	      orderReq.put("receipt", cusOrder.getEmail());
    	   
    	         this.client = new RazorpayClient(razorPayKey, razorPaySecret) ;
    	       	      Order razorPayOrder = client.orders.create(orderReq); 
    	        log.info("order is created in razorpay : {}", razorPayOrder);
	    	        
    	         cusOrder.setRazorpayOrderId(razorPayOrder.get("id"));
    	         cusOrder.setOrderStatus(razorPayOrder.get("status"));
	    	         
	    	         customerRepo.save(cusOrder);
	    	          log.info("customer data have been saved in database : {} ",cusOrder);
	    	          
	    	           return cusOrder ;
	    	      
	       }
	       
}
