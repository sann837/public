package com.psbparks.tenantportal.service;

import java.sql.SQLException;
import javax.naming.NamingException;

import com.psbparks.tenantportal.dao.RegistrationDAO;
import com.psbparks.tenantportal.model.*;

/**
 * @author Sandeep Thandra 
 * This class is designed to saveRegistration details by
 * passing details to RegistrationDAO class
 *
 */
public class RegistrationService {

	/**
	 * This method is defined to saverRegistration detials and get
	 * registrationid this can be acheived by calling the method in the DAO
	 * layer and passing the objects method reuturn the registration id
	 */
	public int saveRegistrationDetails(Company company, Tenant tenant) {

		RegistrationDAO regDao = new RegistrationDAO();
		int registrationId = 0;
		try {
			registrationId = regDao.saveCompanyDetails(company);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			regDao.saveTenantDetails(tenant);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return registrationId;

	}

}
