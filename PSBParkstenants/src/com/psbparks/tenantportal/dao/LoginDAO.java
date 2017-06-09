package com.psbparks.tenantportal.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.psbparks.tenantportal.util.DbUtil;

/**
 * @author Sandeep Thandra 
 * This Class is designed to store the data which we get
 * througth service and controller classes from the form input we store
 * data into database by making connection an writing Sql Quiries
 *
 */
public class LoginDAO {

	Connection conn;
	PreparedStatement prpdStmt;

	/**
	 * This method is defined sucth that it takes the arguments userid and
	 * password from the user and verifies them by retrieving already saved
	 * userid and password from the database through sql query and returns
	 * boolean
	 */
	public boolean authenticateUser(String userId, String password)
			throws SQLException, ClassNotFoundException, NamingException {

		DbUtil dbUtil = new DbUtil();
		boolean isValid = false;

		ResultSet rs = null;
		try {

			conn = dbUtil.getConnectionByProperties();

			prpdStmt = conn.prepareStatement("SELECT userid,pasword FROM company WHERE userid ='" + userId
					+ "' AND pasword ='" + password + "'");

			rs = prpdStmt.executeQuery();

			while (rs.next()) {

				if (rs.getString(1) == userId && rs.getString(2) == password);

				isValid = true;

			}

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}

		return isValid;
	}
}
