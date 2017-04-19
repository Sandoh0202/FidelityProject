package com.workshop.tradr.team5;

public class Customer {
	
	public String customer_name, username, password, secretQ, secretA, invest_trader , gender , household_id, dob;
	
	public Customer (String customer_name , String username, String password, String secretQ, String secretA, String dob, String gender, String invest_trader, String household_id)  {
		
		this.customer_name = customer_name;
		this.username = username;
		this.password = password;
		this.secretQ = secretQ;
		this.secretA = secretA;
		this.dob = dob;
		this.gender = gender;
		this.household_id = household_id;
		this.invest_trader = invest_trader;		
	}
}
