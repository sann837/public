package com.creditcard.application.process;

import java.util.Scanner;

public class CreditCardController {

	
	public void enterDetails(){
		
		
		System.out.println("Online Application Form For CreditCard:");
		System.out.println("\n Please Fill The Below Form");
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("\nEnter your First Name:");
		String firstname = input.nextLine();
		
		System.out.print("Enter your last Name:");
		String lastname = input.nextLine();
		
		System.out.print("Enter Your social security number Number:");
		String ssn = input.nextLine();
		if (ssn.length() < 9 || ssn.length() > 9) {
			System.out.print("please enter a valid ssn number");
		}
		
		System.out.print("Enter your Date Of Birth(MM/DD/YYY):");
		String dateofbirth = input.nextLine();
		
		System.out.print("enter your age:");
		int age = input.nextInt();
		if(age<20){
			System.out.println("Sorry! you are not eligible to apply for a credit card" );
		}
		
		System.out.print("Sex:");
		String sex = input.nextLine();
		
		System.out.print("Enter your annual income: ");
		double annualIncome = input.nextDouble();
		
		System.out.print("Enter your total assests value: ");
		double assestsValue = input.nextDouble();
		
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
		
		System.out.print("your signature:");
		String yoursignature = input.nextLine();
		input.close();
		
		Customer cust = new Customer();
		
		cust.setFirstname(firstname);
		cust.setLastname(lastname);
		cust.setSsn(ssn);
		cust.setDateofbirth(dateofbirth);
		cust.setAge(age);
		cust.setSex(sex);
		cust.setAnnualIncome(annualIncome);
		cust.setAssestsValue(assestsValue);
		cust.setMailingaddressline1(mailingaddressline1);
		cust.setMailingaddressline2(mailingaddressline2);
		cust.setState(state);
		cust.setZipcode(zipcode);
		cust.setPhnumber(phnumber);
		cust.setYoursignature(yoursignature);
		
		CreditCardService cardService = new CreditCardService();
		boolean decision = cardService.processApplication(cust);
		
		if(decision){
			System.out.println("Congratulations your CreditCard is Approved ");
			System.out.println(" card will be mailed to your address in two weeks  ");
		}
		
		
	}
	
	public static void main(String[] args) {
		
		CreditCardController cardController = new CreditCardController();
		cardController.enterDetails();
	}
	
}
