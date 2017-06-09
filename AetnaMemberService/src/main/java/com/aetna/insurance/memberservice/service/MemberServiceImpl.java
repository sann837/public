package com.aetna.insurance.memberservice.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aetna.insurance.memberservice.dao.MemberServiceDAO;
import com.aetna.insurance.memberservice.model.Member;

@Service
@WebService(serviceName = "MemberService" ,endpointInterface = "com.aetna.insurance.memberservice.service.MemberService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberServiceDAO memberDao;
	
	@WebMethod
	@Transactional
	public String createMember(@WebParam(name="Member") Member member) {
		
		for (int i = 0; i < 2; i++) {
			int randomnum = (int) (Math.random() * 10);
			char randomLetter = (char) (Math.random() * 26 + 'a');
			int randomnumber = (int) (Math.random() * 10);
			String idPart1 = Integer.toString(randomnum);
			String idPart2 = Character.toString(randomLetter);
			String idPart3 = Integer.toString(randomnumber);
			
		String	memberId = idPart1+idPart3+idPart2+idPart1;
			member.setMemberId(memberId);
		
		}
		
		return memberDao.createMember(member);
	}

	@WebMethod
	@Transactional
	public List<Member> getMemberById(@WebParam(name="id") String id) {
		
		
		return memberDao.getMemberById(id);
	}

}
