package com.bcj.memberservice.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bcj.memberservice.model.Member;
import com.bcj.memberservice.service.MemberService;


@Controller
public class SpringMVCController {
	
	
	
	MemberService service = new MemberService();
	
	
	@RequestMapping(value = "/helloWorld.web", method = RequestMethod.GET)
	public ModelAndView printWelcome(@ModelAttribute("member") Member member) {

		ModelAndView mav = new ModelAndView("SubmitForm");
		mav.addObject("message", "Hello World!!!");
		return mav;

	}

	@RequestMapping(value="/submitForm.web", method = RequestMethod.POST)
    public @ResponseBody Member  submittedFromData(@RequestBody Member member, HttpServletRequest request) {
		System.out.println(member.getFirstName());
		service.saveCustomer(member);
		
		return member;
	}	
	
}
