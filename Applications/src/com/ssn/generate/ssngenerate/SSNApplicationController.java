package com.ssn.generate.ssngenerate;

import java.util.Scanner;

public class SSNApplicationController {

	public void fillForm() {
		System.out.println("Online Application Form For SSN(social security number):");
		System.out.println("\n Please Fill The Below Form");
		Scanner input = new Scanner(System.in);
		System.out.print("\nEnter your First Name:");
		String firstname = input.nextLine();
		System.out.print("Enter your last Name:");
		String lastname = input.nextLine();
		System.out.print("Enter Your passport Number:");
		String passportnumber = input.nextLine();
		if (passportnumber.length() < 7 || passportnumber.length() > 9) {
			System.out.print("please enter a valid passport number");
		}
		System.out.print("\nEnter your Place of birth:");
		String placeofbirth = input.nextLine();
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
		System.out.print("today's date:");
		String todaysdate = input.nextLine();
		System.out.print("your signature:");
		String yoursignature = input.nextLine();
		input.close();

		SSNApplicationForm af = new SSNApplicationForm(firstname, lastname, passportnumber, placeofbirth, dateofbirth,
				sex, mailingaddressline1, mailingaddressline2, state, zipcode, phnumber, todaysdate, yoursignature);
		SSNApplicationService as = new SSNApplicationService();

		as.generateSSN(af);
	}

	public static void main(String[] args) {

		new SSNApplicationController().fillForm();
	}
}