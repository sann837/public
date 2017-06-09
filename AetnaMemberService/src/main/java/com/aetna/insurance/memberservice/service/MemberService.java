package com.aetna.insurance.memberservice.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import com.aetna.insurance.memberservice.model.Member;

@WebService(name = "MemberService")
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL)
public interface MemberService {

	@WebMethod
	public String createMember(@WebParam(name="Member") Member member );
	
	@WebMethod
	public List<Member> getMemberById(@WebParam(name="id") String id);
	
}
