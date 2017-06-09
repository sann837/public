package com.ead.generate.eadnumbergenerate;


import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class EADApplicationService {

	EADApplicationDAO eaddao = new  EADApplicationDAO();
	
	public void generateEAD(EADApplicationForm ead){
		
		if(ead != null){
			System.out.println("nnn"+ead.getFirstname()+"kkk");
			Random r = new Random();
			long ssn = r.nextInt(900000000) + 100000000;
			String ssn1 = Long.toString(ssn);
			String group1 = ssn1.substring(0, 3);
			String group2 = ssn1.substring(3, 6);
			String group3 = ssn1.substring(6, 9);
			String EADnumber = group1 + "-" + group2 + "-" + group3;
			
		    Calendar date = Calendar.getInstance();
		    date.setTime(new Date());
		    Format f = new SimpleDateFormat("MMMM-dd-yyyy");
		     String  startdate = f.format(date.getTime());
		    date.add(Calendar.YEAR,1);
		    String enddate = f.format(date.getTime());
		    
			ead.setEADnumber(EADnumber);
		    ead.setStartdate(startdate);
		    ead.setEnddate(enddate);
		    eaddao.displayEAD(ead);
			
		}
		else{
			System.out.println("invalid details,please check your details");
		}
		
	}
	
}
