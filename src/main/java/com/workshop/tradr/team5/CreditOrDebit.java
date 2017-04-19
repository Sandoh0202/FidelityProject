package com.workshop.tradr.team5;

public class CreditOrDebit {
	
	String customer_id  , name, amount, debitorcredit, option;
	public CreditOrDebit(String customer_id  , String  name, String  amount, String  debitorcredit, String option) {
		
		this.customer_id = customer_id.substring(customer_id.lastIndexOf(',') + 1);
		this.name = name.substring(name.lastIndexOf(',')  + 1);
		this.amount =amount.substring(amount.lastIndexOf(',')  + 1);;
		
		int start=-1 , last=0;
		
		for(int i=0 ; i<debitorcredit.length(); i++) {
			
			char ch =debitorcredit.charAt(i); 
			if( Character.isDigit(ch) && start == -1)
				start = i;
			if( Character.isDigit(ch))
				last = i;
		}
		
		this.debitorcredit = debitorcredit.substring(start , last+1);
		this.option = option.toUpperCase();
		
	}
}
