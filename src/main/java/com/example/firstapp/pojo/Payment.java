package com.example.firstapp.pojo;

public class Payment{

	private long id;
    private double amount;
    private String currency;
    
    
	public Payment(long id, double amount, String currency) {
		super();
		this.id = id;
		this.amount = amount;
		this.currency = currency;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
}
