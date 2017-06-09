package com.psbparks.tenantportal.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.psbparks.tenantportal.model.Company;
import com.psbparks.tenantportal.model.Tenant;
import com.psbparks.tenantportal.util.DbUtil;

/**
 * @author Sandeep Thandra 
 * This Class is designed to store the data which we get
 * througth service and controller classes from the form input we store
 * data into database by making connection an writing Sql Quiries
 *
 */
public class RegistrationDAO {

	Connection conn;
	PreparedStatement prpdStmt;
	int registrationId;
	DbUtil dbUtil = new DbUtil();
	

	/**
	 * This method defined to save companydetails which we get from the user
	 * input form in to the database here we make the connection to the database
	 * and using sql queries we insert data and we are using auto generated keys
	 * also which we insert into other tables where we need
	 * @throws NamingException 
	 */
	public int saveCompanyDetails(Company company) throws SQLException, ClassNotFoundException, NamingException {

		int comAddId = 0;
		  final Logger logger = Logger.getLogger(RegistrationDAO.class);
		 
	

		try {
			
			PropertyConfigurator.configure("log4j.properties");
			
			conn = dbUtil.getConnectionByProperties();
		
			prpdStmt = conn.prepareStatement(
					"INSERT INTO address(addressline1,addressline2,city,state,country,zipcode) VALUES(?,?,?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);

			logger.info(conn);

			prpdStmt.setString(1, company.getAddress().getAddressLine1());
			prpdStmt.setString(2, company.getAddress().getAddressLine2());
			prpdStmt.setString(3, company.getAddress().getCity());
			prpdStmt.setString(4, company.getAddress().getState());
			prpdStmt.setString(5, company.getAddress().getCountry());
			prpdStmt.setString(6, company.getAddress().getZipcode());

			prpdStmt.execute();

			ResultSet rs1 = prpdStmt.getGeneratedKeys();
			if (rs1 != null && rs1.next()) {

				comAddId = rs1.getInt(1);

			}

			prpdStmt = conn.prepareStatement(
					"INSERT INTO company(name,email,phone,a_id,userid,pasword) VALUES(?,?,?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);

			prpdStmt.setString(1, company.getName());
			prpdStmt.setString(2, company.getEmail());
			prpdStmt.setString(3, company.getPhone());
			prpdStmt.setInt(4, comAddId);
			prpdStmt.setString(5, company.getUserId());
			prpdStmt.setString(6, company.getPassword());

			prpdStmt.execute();
			ResultSet rs2 = prpdStmt.getGeneratedKeys();

			if (rs2 != null && rs2.next()) {

				registrationId = rs2.getInt(1);
			}

		}

		catch (IOException e) {

			e.printStackTrace();
		}

		return registrationId;
	}

	/**
	 * This method defined to save Tenantdetails which we get from the user
	 * input form in to the database here we make the connection to the database
	 * and using sql queries we insert data and we are using auto generated keys
	 * also which we insert into other tables where we need.
	 * @throws NamingException 
	 */
	public void saveTenantDetails(Tenant tenant) throws SQLException, ClassNotFoundException, NamingException {

		int tenAddId = 0;
		try {
			conn = dbUtil.getConnectionByProperties();
			
			
			
			
			prpdStmt = conn.prepareStatement(
					"INSERT INTO address(addressline1,addressline2,city,state,country,zipcode) VALUES(?,?,?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);

			prpdStmt.setString(1, tenant.getAddress().getAddressLine1());
			prpdStmt.setString(2, tenant.getAddress().getAddressLine2());
			prpdStmt.setString(3, tenant.getAddress().getCity());
			prpdStmt.setString(4, tenant.getAddress().getState());
			prpdStmt.setString(5, tenant.getAddress().getCountry());
			prpdStmt.setString(6, tenant.getAddress().getZipcode());

			prpdStmt.execute();

			ResultSet rs1 = prpdStmt.getGeneratedKeys();
			if (rs1 != null && rs1.next()) {

				tenAddId = rs1.getInt(1);
			}

			prpdStmt = conn.prepareStatement(
					"INSERT INTO tenant(firstname,lastname,email,phone,companyid,a_id) VALUES(?,?,?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);

			prpdStmt.setString(1, tenant.getFirstName());
			prpdStmt.setString(2, tenant.getLastName());
			prpdStmt.setString(3, tenant.getEmail());
			prpdStmt.setString(4, tenant.getPhone());
			prpdStmt.setInt(5, registrationId);
			prpdStmt.setInt(6, tenAddId);

			prpdStmt.execute();

		} catch (SQLException | IOException e) {

			e.printStackTrace();
		}

		/* Closing the database connection */
		finally {
			if (conn != null) {
				conn.close();
			}

		}

	}
}
