package com.creditcard.application.process;

public class CreditCardService {

	
	public boolean processApplication(Customer cust){
		
		if(cust.getAnnualIncome()>60000){
			return true;
		}
		
	else if(cust.getAnnualIncome() > 50000 && cust.getAnnualIncome() <60000){
			
			return true;
		}
		else if(cust.getAnnualIncome() > 35000 && cust.getAnnualIncome() <50000){
		
		return true;
		}
		else if(cust.getAnnualIncome() > 20000 && cust.getAnnualIncome() <35000){
			
			return true;
		}
		else{
			return false;
		}
	}
	
}
