package com.workshop.tradr.team5;

public class CreditDebitDetails {
	
	public int customer_id ;
	public String name ;
	public double amount;
	
	public	CreditDebitDetails(int customer_id, String name, double amount)  {		
		this.customer_id = customer_id;
		this.name = name;
		this.amount = amount;
	}
}
