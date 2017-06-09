package com.psbparks.tenantportal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
/*import javax.servlet.annotation.WebServlet;*/
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.psbparks.tenantportal.model.*;
import com.psbparks.tenantportal.service.RegistrationService;

/**
 * @author Sandeep Thandra 
 * Servlet implementation class RegistrationServlet
 * RegistrationServlet class is designed to get the form data which is
 * given by the user from the user interface and the form data will be
 * set to the entity classes
 */
/* @WebServlet("/RegistrationServlet") */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response) 
	 *   Using dopost method we are setting the values to entity
	 *   classes and calling method in the RegistrationService class and
	 *   passing the objects of entity class
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);

		String companyName = request.getParameter("name");
		String cEmail = request.getParameter("email");
		String cPhone = request.getParameter("phonenumber");
		String userId = request.getParameter("userid");
		String password = request.getParameter("password");

		String cAddressLine1 = request.getParameter("addressline1");
		String cAddressLine2 = request.getParameter("addressline2");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String country = request.getParameter("country");
		String zipcode = request.getParameter("zipcode");

		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String tEmail = request.getParameter("temail");
		String tPhone = request.getParameter("tphonenumber");

		String tAddressLine1 = request.getParameter("taddressline1");
		String tAddressLine2 = request.getParameter("taddressline2");
		String tCity = request.getParameter("tcity");
		String tState = request.getParameter("tstate");
		String tCountry = request.getParameter("tcountry");
		String tZipcode = request.getParameter("tzipcode");

		Company company = new Company();
		company.setName(companyName);
		company.setEmail(cEmail);
		company.setPhone(cPhone);
		company.setUserId(userId);
		company.setPassword(password);

		Address comAdd = new Address();
		comAdd.setAddressLine1(cAddressLine1);
		comAdd.setAddressLine2(cAddressLine2);
		comAdd.setCity(city);
		comAdd.setState(state);
		comAdd.setCountry(country);
		comAdd.setZipcode(zipcode);

		company.setAddress(comAdd);

		Tenant tenant = new Tenant();
		tenant.setFirstName(firstName);
		tenant.setLastName(lastName);
		tenant.setEmail(tEmail);
		tenant.setPhone(tPhone);

		Address tenAdd = new Address();
		tenAdd.setAddressLine1(tAddressLine1);
		tenAdd.setAddressLine2(tAddressLine2);
		tenAdd.setCity(tCity);
		tenAdd.setState(tState);
		tenAdd.setCountry(tCountry);
		tenAdd.setZipcode(tZipcode);

		tenant.setAddress(tenAdd);

		RegistrationService regService = new RegistrationService();
		int registrationId = regService.saveRegistrationDetails(company, tenant);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		/*
		 * Here we are displaying the registration id to the user on the we page
		 */
		out.println("<h3>Thank you For Registration</h3>");
		out.println("<h3>your RegistrationId is:" + registrationId + "</h3>");
		out.print("<a href = login1.html>Click here to login</a>");
		out.println("<html><body>");

	}

}
