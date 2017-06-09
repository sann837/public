package com.aetna.insurance.memberservice.dao;

import java.util.List;

import com.aetna.insurance.memberservice.model.Member;

public interface MemberServiceDAO {

	
	public String createMember(Member member);
	
	public List<Member> getMemberById(String id);
}
