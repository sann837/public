package com.maxxis.ccprocessing.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.maxxis.ccprocessing.model.Applicant;
import com.maxxis.ccprocessing.model.CreditCard;


@Transactional
@Repository
public class ApplicationDAO {


	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}



	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	
	public List<Applicant> getApplicationByStatus(){
		
		
		Session session = this.sessionFactory.openSession();
	
		Query query = session.createQuery("from Applicant Where applicationStatus = :status");
		query.setString("status", "New");
		List<Applicant> applicant =query.list();

		return applicant;	
		
	}
	
	
	public void saveCreditCardDetails(CreditCard creditCard){
	
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(creditCard);
		tx.commit();
		
		
	}
	public void updateAppStatus(Applicant applicant){
		
		Session session = this.sessionFactory.openSession();
	Transaction tx = session.beginTransaction();
		session.update(applicant);
		tx.commit();
		
	}
}
