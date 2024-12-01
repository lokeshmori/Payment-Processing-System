package com.mycompany.ps.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="customer_order")

public class CustomerOrder {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer orderId ;
   private String name ;
   private String email ;
   private String phno ;
   private String course ;
   private Integer amount ;
   private String orderStatus ;
   private String razorpayOrderId ;
	
	
	    public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhno() {
		return phno;
	}
	public void setPhno(String phno) {
		this.phno = phno;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getRazorpayOrderId() {
		return razorpayOrderId;
	}
	public void setRazorpayOrderId(String razorpayOrderId) {
		this.razorpayOrderId = razorpayOrderId;
	}
	@Override
	public String toString() {
		return "CustomerOrder [orderId=" + orderId + ", name=" + name + ", email=" + email + ", phno=" + phno
				+ ", course=" + course + ", amount=" + amount + ", orderStatus=" + orderStatus + ", razorpayOrderId="
				+ razorpayOrderId + "]";
	}
		
	   
	   
	   
}
