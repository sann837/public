package com.psbparks.tenantportal.controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
/*import javax.servlet.annotation.WebServlet;*/
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.psbparks.tenantportal.service.LoginService;

/**
 * @author Sandeep Thandra 
 * Servlet implementation class LoginServlet This
 * LoginServlet class is designed to get the form data which is given by
 * the user from the user interface and the form data will be set to the
 * entity classes
 */
/* @WebServlet("/LoginServlet") */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response) 
	 *      Using dopost method we are getting the values and passing them to 
	 *      method in the LoginService class
	 *     
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		doGet(request, response);

		String userId = request.getParameter("userid");
		String password = request.getParameter("password");

		LoginService login = new LoginService();
		 

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		/*
		 * based on boolean value using decision making statement we are
		 * displaying the http respone to the user
		 */
		if (login.authenticateUser(userId, password)) {
			
			
			out.print("<h3>you are successfully looged in</h3>");										
			out.print("<br><br><button><a href = payment.html>Click here to pay your rent</a></button>");			
		} else {
			
			out.print("<img src = https://support.pokemongo.nianticlabs.com/hc/en-us/article_attachments/211649668/02_failed.png class=img></img>");										
			
			out.println("<h2>please check your userid and password</h2>");
			out.print("<a href = login.html>Click here to login</a>");
			out.println("</body></html>");
		}

	}

}
