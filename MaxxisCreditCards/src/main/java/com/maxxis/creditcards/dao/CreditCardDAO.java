package com.maxxis.creditcards.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.maxxis.creditcards.model.Applicant;
import com.maxxis.creditcards.model.CreditCard;
import com.maxxis.creditcards.model.Customer;


/**
 * @author Sandeep Rao Thandra
 * This persistence bean class have different methods to perform operations related to database
 *
 */
@Repository
@Transactional
public class CreditCardDAO {

	private static final Logger logger = LoggerFactory.getLogger(CreditCardDAO.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * @param applicant
	 * Takes the applicant from the service and using session object and HQL query applicant details will be saved
	 * into database as application status as new
	 */
	public void saveApplicant(Applicant applicant) {

		applicant.setApplicationStatus("New");
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(applicant);

		logger.info(" application successfully, application Details=" + applicant.toString());

	}

	/**
	 * @param cust
	 * Takes the registration details from the service and verify the cardNumber and save the customer with details 
	 * using session object and HQL queries
	 */
	public boolean register(Customer cust) {

		Session session = this.sessionFactory.getCurrentSession();
		String cardnumber = cust.getCardNumber();

		Query query1 = session.createQuery(" FROM Customer where CardNumber =:cardNumber");
		query1.setParameter("cardNumber", cardnumber);
		
		Customer cardFrmCust = (Customer) query1.uniqueResult();
		

		if (cardFrmCust == null) {

			boolean isValidCard = false;

			Query query2 = session.createQuery(" FROM CreditCard where creditCardNumber =:cardNumber");
			query2.setParameter("cardNumber", cardnumber);

			CreditCard card = (CreditCard) query2.uniqueResult();
			if (card != null) {
				cust.setApplictnId(card.getCustId());

				session.persist(cust);
				logger.info("Person saved successfully, Person Details=" + cust.toString());
				isValidCard = true;

			} else {
				
				isValidCard = false;
			}
			return isValidCard;
		} else {
			logger.info(cardFrmCust.toString());
			return false;
		}

	}

	/**
	 * @param cust
	 * Takes the Customer details from the service and verifies the customer from database using HQL and session objects
	 * returns creditcard information of that customer it exists
	 */
	public CreditCard verifyCustomer(Customer cust) {

		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Customer where UserID =:Userid AND Password = :password");

		query.setParameter("Userid", cust.getUserID());
		query.setParameter("password", cust.getPassword());

		Customer custmer = (Customer) query.uniqueResult();

		if (custmer != null) {
			logger.info(" Person Details=" + custmer.toString());

			Query query1 = session.createQuery("FROM CreditCard where custId =:custId");
			query1.setParameter("custId", custmer.getApplictnId());

			CreditCard creditCard = (CreditCard) query1.uniqueResult();
			return creditCard;
			
		} else {
			return null;
		}

	}

	/**
	 * @param creditCard
	 * Takes the credit card Number  from service and verify the card from the database if valid card 
	 * it activates the card and changes the card status.
  	 */
	public boolean activateCard(CreditCard creditCard) {

	
		Session session = this.sessionFactory.getCurrentSession();

		Query query = session
				.createQuery("FROM CreditCard where creditCardNumber =:ccNumber AND cardStatus =:cardstatus");
		
		query.setParameter("ccNumber", creditCard.getCreditCardNumber());
		query.setParameter("cardstatus", "Not Active");
		
		CreditCard card = (CreditCard) query.uniqueResult();
		
		if (card != null) {
			
			card.setCardStatus("Active");
			session.update(card);
			
			logger.info("card Person Details=" + card.toString());
			return true;
		} else {
			return false;
		}

	}

}
