package com.bcj.memberservice.EkthaSolutionsService.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.bcj.memberservice.EkthaSolutionsService.dao.MemberDAO;
import com.bcj.memberservice.EkthaSolutionsService.model.Member;


@Path("/json/product")
public class MemberService {

	
	MemberDAO dao = new MemberDAO();
	
	@POST
	@Path("/post")
	@Consumes("application/json")
	@Produces("application/json")
	public String saveApplicant(Member member) {

		System.out.println(member.getFirstName());
		System.out.println(member.getLastName());
			dao.saveApplicant(member);
		 		 return "Success";
	}
	
	
	@GET
	@Path("/set")
	@Produces("application/json")
	public String getTest() {

		return "Success";
	}
	
	
}
