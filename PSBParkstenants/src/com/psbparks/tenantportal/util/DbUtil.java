package com.psbparks.tenantportal.util;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * @author Sandeep Thandra This Class is designed to make database connection in
 *         two different ways
 *
 */
public class DbUtil {

	Connection conn = null;

	/**
	 * This method is defined to make database connection by hardcoding the
	 * values of dburl and drivername and username and paasword and the method
	 * returns the conn object reference if connection is success.
	 */
	public Connection getConnectionByHardCode() throws SQLException, ClassNotFoundException {

		if (conn != null) {
			return conn;
		} else {
			try {

				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/psbparks?useSSL=true", "root", "8037");
			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			} catch (SQLException e) {

				e.printStackTrace();
			}

			return conn;
		}
	}

	/**
	 * * This method is defined to make database connection by using the
	 * properties file in that file we have dburl and drivername and username
	 * and paasword values as key value based collection. and the method returns
	 * the conn object reference if connection is success.
	 * 
	 * @throws IOException
	 */
	public Connection getConnectionByProperties() throws SQLException, ClassNotFoundException, IOException {

		Properties prop = new Properties();
		InputStream inputStream = null;

		if (conn != null) {
			return conn;
		}

		else {
			try {
				
                inputStream = new FileInputStream("dbconn.properties");
				
			/*	inputStream = this.getClass().getClassLoader().getResourceAsStream("dbconn.properties");*/
				if (inputStream != null) {
					
				prop.load(inputStream);
		
				}
				String dbDriver = prop.getProperty("dbDriver");
				String connectionUrl = prop.getProperty("connectionUrl");
				String userName = prop.getProperty("userName");
				String password = prop.getProperty("password");

				Class.forName(dbDriver);
				conn = DriverManager.getConnection(connectionUrl, userName, password);

			} catch (Exception e) {

				e.printStackTrace();
			}
			
			
			return conn;
		}
	}

	public Connection getConnectionByDatasource() throws NamingException, SQLException {

		if (conn != null) {
			return conn;
		}

		try {
			Context context = new InitialContext();

			DataSource ds = (DataSource) context.lookup("mydb");
			conn = ds.getConnection();
		} catch (Exception e) {

			e.printStackTrace();
		}

		return conn;

	}

	
	  public static void main(String[] args){
	  
	 try { new DbUtil().getConnectionByProperties(); } catch
	  (ClassNotFoundException | SQLException | IOException e) { 
	   e.printStackTrace(); } }
	 

}
