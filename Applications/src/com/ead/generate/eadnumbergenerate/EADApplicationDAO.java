package com.ead.generate.eadnumbergenerate;

public class EADApplicationDAO {

	
	public void displayEAD(EADApplicationForm ead){
		
		System.out.println("\nThank you for your Application");
		System.out.println("\nYour EAD number is:"+ead.getEADnumber()+"\nvalid from:   "+ead.getStartdate()+" to "+ead.getEnddate());
		
		
	}
	
}
