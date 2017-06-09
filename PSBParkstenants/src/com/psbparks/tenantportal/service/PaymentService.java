package com.psbparks.tenantportal.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.psbparks.tenantportal.model.CreditCard;

/**
 * @author Sandeep Thandra 
 * This class is designed to handle the payment details
 * we get from controller class.
 *
 */
public class PaymentService {

	/*
	 * Here we are reading the input file which have alreday loaded payment
	 * details
	 */
	

    private static  Logger logger = Logger.getLogger(PaymentService.class);
	
	
	
	
	
	/**
	 * This method is designed to verify the payment details using buffered
	 * reader and file reader if all the details matches with the file method
	 * return boolean as true and we need to close the connections also.
	 */
	public boolean verifyPayment(CreditCard cCard) {
		
		

		boolean isVerified = false;
		BufferedReader cCardFileRead = null;
		FileReader fileRead = null;
		String[] cardDetails = null;
		String line = null;

		try {
			
			PropertyConfigurator.configure("log4j.properties");
			
		     Reader	inputFile = new FileReader("creditcarddetails");
			
			cCardFileRead = new BufferedReader(inputFile);
			logger.info(cCardFileRead);

			while ((line = cCardFileRead.readLine()) != null) {

				cardDetails = line.split(" ");

				if (cardDetails[0].equals(cCard.getCardNumber())
						&& cardDetails[1].equalsIgnoreCase(cCard.getNameoncard())
						&& cardDetails[2].equals(cCard.getCvv()) && cardDetails[3].equals(cCard.getExpiryDate())
						&& Double.parseDouble(cardDetails[4]) >= cCard.getAmount()) {

					isVerified = true;

				}

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e);
		} finally {

			if (fileRead != null) {
				try {
					fileRead.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (cCardFileRead != null) {
					try {
						cCardFileRead.close();
					} catch (IOException e) {

						e.printStackTrace();
					}

				}
			}
		}
      logger.info(isVerified);
		return isVerified;

	}

}
