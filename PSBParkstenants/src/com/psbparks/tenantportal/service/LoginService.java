package com.psbparks.tenantportal.service;

import java.sql.SQLException;
import javax.naming.NamingException;
import com.psbparks.tenantportal.dao.LoginDAO;

/**
 * @author Sandeep Thandra 
 * This class is designed to handle the usename and
 * password given by the user as input form
 *
 */
public class LoginService {

	/**
	 * This method is defined to authenticate user by passing the userid and
	 * password as parameters to the LoginDAO and returns the boolean
	 */
	public boolean authenticateUser(String userId, String password) {

		LoginDAO login = new LoginDAO();
		boolean isVAlid = false;

		try {
			try {
				isVAlid = login.authenticateUser(userId, password);
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return isVAlid;

	}
}
