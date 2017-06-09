package com.bcj.memberservice.EkthaSolutionsService.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.bcj.memberservice.EkthaSolutionsService.model.Member;
import com.bcj.memberservice.EkthaSolutionsService.util.HibernateUtil;




public class MemberDAO {

	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	
	public void saveApplicant(Member member) {

		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();
		session.persist(member);
		tx.commit();
		session.close();

	}
}
