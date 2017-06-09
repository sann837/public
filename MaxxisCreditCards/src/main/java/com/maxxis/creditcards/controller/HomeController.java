package com.maxxis.creditcards.controller;


import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.maxxis.creditcards.model.Applicant;
import com.maxxis.creditcards.model.CreditCard;
import com.maxxis.creditcards.model.Customer;
import com.maxxis.creditcards.service.CreditCardService;



/**
 * @author Sandeep Rao Thandra 
 * Handles requests for the application home page and other pages.
 */
@Controller
public class HomeController {

	@Autowired
	CreditCardService creditCardService;

	public void setCreditCardService(CreditCardService creditCardService) {
		this.creditCardService = creditCardService;
	}

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(Locale locale, Model model) {

		logger.info("Home page is requested");

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return new ModelAndView("signin");
	}

	/**
	 * Renders the application form when request comes to application page
	 */
	@RequestMapping(value = "/application", method = RequestMethod.GET)
	public ModelAndView goToApplicationForm() {

		logger.info("application page requested");

		return new ModelAndView("application");

	}

	/**
	 * @param applicant
	 * @param model
	 * @return ModelAndView 
	 * Takes the form submission and passes to srvice class
	 * and returns ModelAndview
	 */
	@RequestMapping(value = "/apply", method = RequestMethod.POST)
	public ModelAndView saveApplicat(@ModelAttribute("applicant") Applicant applicant, ModelMap model) {

		creditCardService.saveApplicant(applicant);
		logger.info("application is saved");

		model.addAttribute("applicant", applicant);
		String applictn = "Thank you! your application is submitted successfully We will notify your application status through email";

		return new ModelAndView("application", "applictn", applictn);

	}

	/**
	 * @return ModelAndView 
	 * Renders the registration form page whenever requested
	 */
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView goToRegistrationForm() {

		logger.info("registration page requested");

		return new ModelAndView("registration");
	}

	/**
	 * @param customer
	 * @param result
	 * @param model
	 * @return 
	 * Accepts the registration form and passes to service class and
	 * returns the ModelAndView
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView register(@ModelAttribute("customer") Customer customer, BindingResult result, ModelMap model) {

		model.addAttribute("customer", customer);

		if (creditCardService.register(customer)) {

			String regstatus = "Thank you! you are successfully registered";
			logger.info("registration succesful");

			return new ModelAndView("registration", "regstatus", regstatus);
		} else {
			String regstatus = "Please check your CardNumber either it already registerd or does not exist";
			logger.info("registration failed for some reason");

			return new ModelAndView("registration", "regstatus", regstatus);
		}
	}

	/**
	 * @param customer
	 * @param result
	 * @param model
	 * Handles the request for the sign page and accepts the signin
	 * parameters and passes to service bean and returns ModelAndView
	 */
	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public ModelAndView goToProfile(@ModelAttribute("customer") Customer customer, BindingResult result,
			ModelMap model) {

		model.addAttribute("customer", customer);

		CreditCard creditCard = creditCardService.verifyCustomer(customer);

		if (creditCard != null) {
			logger.info(creditCard.toString());
			return new ModelAndView("custprofile", "profile", creditCard);
		} else {

			String message = "please check your UserId and Password";
			return new ModelAndView("custprofile", "message", message);

		}

	}

	/**
	 * Handles the requests for the card activation page and passes the card to
	 * service class returns ModelAndView
	 */
	@RequestMapping(value = "/activatecard", method = RequestMethod.POST)
	public ModelAndView activateCard(@ModelAttribute("CreditCard") CreditCard creditCard, BindingResult result,
			ModelMap model) {

		logger.info(creditCard.toString());

		if (creditCardService.activateCard(creditCard)) {

			String Activation = "Thank you! your card is successfully activated";
			return new ModelAndView("cardactivation", "message", Activation);
		} else {
			String message = "please check your card number,enter valid cardNumber";
			return new ModelAndView("cardactivation", "message", message);
		}
	}

	/**
	 * Handles the requests coming to card activation page returns the view
	 */
	@RequestMapping(value = "/cardactivation", method = RequestMethod.GET)
	public ModelAndView goToCardactivationForm() {

		return new ModelAndView("cardactivation");

	}

}