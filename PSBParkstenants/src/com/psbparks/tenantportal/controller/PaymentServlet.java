package com.psbparks.tenantportal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.psbparks.tenantportal.model.CreditCard;
import com.psbparks.tenantportal.service.PaymentService;

/**
 * Servlet implementation class PaymentServlet
 */
/*@WebServlet("/PaymentServlet")*/
/**
 * @author Sandeep Thandra 
 * PaymentServlet class is designed to get the form data
 * which is given by the user from the user interface and the form data
 * will be set to the entity classes
 *
 */
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response) 
	 *      
	 *   Using dopost method we are setting the values to entity
	 *   classes and calling method in the PaymentService class and passing
	 *   the objects of entity class
	 * 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		String cardNumber = request.getParameter("cardNumber");
		String nameOnCard = request.getParameter("nameOnCard");
		String cvv = request.getParameter("CVV");
		String expiryDate = request.getParameter("cardExpiry");
		double amount = Double.parseDouble(request.getParameter("amount"));

		CreditCard cCard = new CreditCard();

		cCard.setCardNumber(cardNumber);
		cCard.setNameoncard(nameOnCard);
		cCard.setCvv(cvv);
		cCard.setExpiryDate(expiryDate);
		cCard.setAmount(amount);

		PaymentService paymntService = new PaymentService();
		boolean isSuccess = paymntService.verifyPayment(cCard);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		/*
		 * based on boolean value using decision making statement we are
		 * displaying the http respone to the user
		 */
		if (isSuccess) {		
			out.print("<img src = http://www.huahinstay.com/data/content/42/data/efhnopqtu457.jpg class=img></img>");					
		} else {
			out.println("<html><body>");
			out.println("Sorry Your payment is failed");
			out.print("<a href = payment.html>Click here to pay</a>");
			out.print("</body></html>");
		}
	}

}
