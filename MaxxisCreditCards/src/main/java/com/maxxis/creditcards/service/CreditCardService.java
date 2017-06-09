package com.maxxis.creditcards.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maxxis.creditcards.dao.CreditCardDAO;
import com.maxxis.creditcards.model.Applicant;
import com.maxxis.creditcards.model.CreditCard;
import com.maxxis.creditcards.model.Customer;



/**
 * @author Sandeep Rao Thandra 
 * This is service Bean class which have different
 * methods to perform operations based on the requirement
 */
@Transactional
@Service
public class CreditCardService {

	@Autowired
	CreditCardDAO creditCardDao;

	private static final Logger logger = LoggerFactory.getLogger(CreditCardService.class);

	public void setCreditCardDao(CreditCardDAO creditCardDao) {
		this.creditCardDao = creditCardDao;
	}

	/**
	 * @param applicant
	 *   Takes the applicant parameters from controller and passes to
	 *   persistence layer to save the applicant details
	 */
	public void saveApplicant(Applicant applicant) {

		creditCardDao.saveApplicant(applicant);
	}

	/**
	 * @param cust
	 *    Takes the customer parameters from controller and passes to
	 *    persistence layer to save registration details
	 */
	public boolean register(Customer cust) {

		return creditCardDao.register(cust);

	}

	/**
	 * @param cust
	 *    Takes the Customer object from the controller and passes to
	 *    persistence layer to verify customer
	 */
	public CreditCard verifyCustomer(Customer cust) {

		return creditCardDao.verifyCustomer(cust);

	}

	/**
	 * @param creditCard
	 *   Takes the Creditcard Information from the controller and
	 *   passes to the persistence layer
	 */
	public boolean activateCard(CreditCard creditCard) {

		if (creditCardDao.activateCard(creditCard)) {

			return true;
		} else {
			return false;
		}
	}

}
