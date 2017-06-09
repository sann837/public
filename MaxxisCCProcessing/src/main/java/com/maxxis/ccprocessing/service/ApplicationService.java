package com.maxxis.ccprocessing.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maxxis.ccprocessing.dao.ApplicationDAO;
import com.maxxis.ccprocessing.emailservice.EmailService;
import com.maxxis.ccprocessing.model.Applicant;
import com.maxxis.ccprocessing.model.CreditCard;

@Transactional
@Service
public class ApplicationService {

	@Autowired
	private ApplicationDAO applicationDao;

	public void setApplicationDao(ApplicationDAO applicationDao) {
		this.applicationDao = applicationDao;
	}

	public void processApplication() {

		List<Applicant> applicant = applicationDao.getApplicationByStatus();

		ExecutorService executor = Executors.newFixedThreadPool(5);// creating a
		// pool of 5
		// threads

		Iterator itr = applicant.iterator();
		while (itr.hasNext()) {

			Applicant applcnt = (Applicant) itr.next();

			Runnable applicThread = new ApplicationThread(applcnt, this);

			executor.execute(applicThread);// calling execute method of
			// ExecutorService
		}
		executor.shutdown();

	}

	public 	void generateAppStatus(Applicant applicant) {

		BufferedReader readDetails = null;
		FileReader fileRead = null;
		String[] applicantDetails = null;
		String line = null;
		EmailService emailService = new EmailService();

		try {
			
			InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("applicantdetails");

		BufferedReader readDetails1 = new BufferedReader(new InputStreamReader(inputStream));

			



			while ((line = readDetails1.readLine()) != null) {

				applicantDetails = line.split(" ");

				if (applicantDetails[0].equals(applicant.getSSN())){
					if(Integer.parseInt(applicantDetails[1]) <= 760 && Integer.parseInt(applicantDetails[2]) >= (Integer.parseInt(applicant.getAnnualIncome()))
							&& Integer.parseInt(applicantDetails[3]) >= Integer.parseInt(applicant.getHouseMortage())) {

						applicant.setApplicationStatus("Approved");

						applicationDao.updateAppStatus(applicant);

						CreditCard creditCard = generateCreditcard(applicant);

						emailService.sendEmail("maxxiscreditsforyou@gmail.com", "Maxxis@837", applicant.getEmail(),
								"creditcard status",
								"Hi Mr/Mrs " + applicant.getFirstName()
								+ " your credit card application is processed and it is approved  your credit limit is"
								+ creditCard.getCardLimit() + "and your card number is" + creditCard.getCreditCardNumber());
					}


					
					else{
						applicant.setApplicationStatus("Rejected");
						applicationDao.updateAppStatus(applicant);
						emailService.sendEmail("maxxiscreditsforyou@gmail.com", "Maxxis@837", applicant.getEmail(),
								"creditcard status",
								"Hi Mr/Mrs " + applicant.getFirstName()
								+ " your credit card application is processed we are sorry we are unable to process your request at this moment"
								+ "please try next time after 2 months");
					}
				}
			}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {

				if (fileRead != null) {
					try {
						fileRead.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (readDetails != null) {
						try {
							readDetails.close();
						} catch (IOException e) {

							e.printStackTrace();
						}

					}
				}
			}
			}


		public CreditCard generateCreditcard(Applicant applicant) {

			CreditCard creditCard = new CreditCard();

			int i = 0;
			String creditCardNumber = "";
			Random r = new Random();
			while (i < 4) {
				long creditCardNumbergrp = r.nextInt(9000) + 1000;
				creditCardNumber = creditCardNumber + " " + creditCardNumbergrp;
				i++;
			}
			int creditLimit = 10000;
			String CVV = Integer.toString(r.nextInt(900) + 100);
			creditCard.setNameOnCard(applicant.getFirstName() + " " + applicant.getLastName());
			creditCard.setCardLimit(creditLimit);
			creditCard.setCreditCardNumber(creditCardNumber);
			creditCard.setCVV(CVV);
			Calendar expiryDate = Calendar.getInstance();
			expiryDate.setTime(new Date());
			Format f = new SimpleDateFormat("dd-MMMM-yyyy");
			expiryDate.add(Calendar.YEAR, 4);
			creditCard.setExpiryDate(f.format(expiryDate.getTime()));
			creditCard.setCustId(applicant.getId());
			creditCard.setCardStatus("Not Active");

			applicationDao.saveCreditCardDetails(creditCard);

			return creditCard;

		}

		}
