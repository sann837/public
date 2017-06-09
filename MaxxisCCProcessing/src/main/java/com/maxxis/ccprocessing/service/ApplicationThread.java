package com.maxxis.ccprocessing.service;

import com.maxxis.ccprocessing.model.Applicant;

public class ApplicationThread implements Runnable{
	
	Applicant applicant;
	
	ApplicationService appservice;
	
	/*public void setAppservice(ApplicationService appservice) {
	
	
		this.appservice = appservice;
	}*/

	public ApplicationThread(Applicant applcnt, ApplicationService appservice) {
	
		this.applicant = applcnt;
		this.appservice = appservice;
		
	}

	public void run() {
		// TODO Auto-generated method stub
		 System.out.println(Thread.currentThread().getName()+" (Start)"); 
			appservice.generateAppStatus(applicant);
			   System.out.println(Thread.currentThread().getName()+" (End)");
	}

	

}
