package com.ead.generate.eadnumbergenerate;

import java.util.Scanner;

public class EADApplicationController {
	
	
	public void fillForm() {
		System.out.println("Online Application Form For EAD(Employment Authorization Document):");
		System.out.println("\n Please Fill The Below Form");
		Scanner input = new Scanner(System.in);
		System.out.print("\nEnter your First Name:");
		String firstname = input.nextLine();
		System.out.print("Enter your last Name:");
		String lastname = input.nextLine();
		System.out.print("Enter Your social security Number:");
		String socialSecurityNumber = input.nextLine();
		if (socialSecurityNumber.length() < 7 || socialSecurityNumber.length() > 9) {
			System.out.print("please enter a valid social security Number");
		}
		System.out.print("please enter your Immigration Status");
		String immigrationStatus = input.nextLine();
		System.out.print("Enter your Date Of Birth(MM/DD/YYY):");
		String dateofbirth = input.nextLine();
		System.out.print("Sex:");
		String sex = input.nextLine();
		System.out.print("Address:");
		System.out.print("\nmailing address line1:");
		String mailingaddressline1 = input.nextLine();
		System.out.print("mailing address line2:");
		String mailingaddressline2 = input.nextLine();
		System.out.print("state:");
		String state = input.nextLine();
		System.out.print("zipcode:");
		String zipcode = input.nextLine();
		System.out.print("phone number:");
		String phnumber = input.nextLine();
		System.out.print("Applicant's signature:");
		String applicantsignature = input.nextLine();
		input.close();
		
		EADApplicationForm eadf = new  EADApplicationForm();
		
		         
		eadf.setFirstname(firstname);
		eadf.setLastname(lastname);
		eadf.setSocialSecurityNumber(socialSecurityNumber);
		eadf.setImmigartionstatus(immigrationStatus);
		eadf.setDateofbirth(dateofbirth);
		eadf.setSex(sex);
		eadf.setMailingaddressline1(mailingaddressline1);
		eadf.setMailingaddressline2(mailingaddressline2);
		eadf.setState(state);
		eadf.setZipcode( zipcode);
		eadf.setPhnumber(phnumber);
		eadf.setApplicantssignature( applicantsignature);
		
		EADApplicationService eads = new  EADApplicationService();
		
        eads.generateEAD(eadf);
	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 EADApplicationController eadc = new  EADApplicationController();
		 eadc.fillForm();
		
	}

}
