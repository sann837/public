package com.aetna.insurance.memberservice.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aetna.insurance.memberservice.model.Member;

@Repository
public class MemberServiceDAOImpl implements MemberServiceDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public String createMember(Member member) {

		Session session = sessionFactory.getCurrentSession();

		session.saveOrUpdate(member);

		/* session.close(); */

		return "You are added to the plan successfully and your Memberid is  " + member.getMemberId();

	}

	@Transactional
	public List<Member> getMemberById(String id) {

		Session session = sessionFactory.getCurrentSession();

		if (id == null) {
			return null;
		} else {
			/*Member member = (Member) session.load(Member.class, id); */

			/*Query query = session.createQuery("from Member where memberId =:id");
			query.setParameter("id", id);

			Member member = (Member) query.uniqueResult();*/


			Criteria crit = session.createCriteria(Member.class);
			ProjectionList projections = Projections.projectionList()
					.add(Projections.property("firstName").as("firstName"))
					.add(Projections.property("lastName").as("lastName"))
					.add(Projections.property("selectedPlan").as("selectedPlan"))
					.add(Projections.property("address").as("address"));

			Criteria membercriteria = session.createCriteria(Member.class,"member");
			membercriteria.setProjection(projections)
			.add(Restrictions.eq("member.memberId", id))
			.setResultTransformer(new AliasToBeanResultTransformer(Member.class));
		
			return (List<Member>) membercriteria.list();




		}
	}
}
