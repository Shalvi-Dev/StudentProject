package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
	public static Connection getOracleConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");	
		return DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:xe", "system", "Shalvi$17");	//Database Connection details
	}
}
