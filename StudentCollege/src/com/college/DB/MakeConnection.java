package com.college.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MakeConnection {
static String URL,USER,PASS;
static {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		ResourceBundle rb=ResourceBundle.getBundle("amit");
		URL=rb.getString("URL");
		USER= rb.getString("USER");
		PASS= rb.getString("PASS");
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
 static Connection getConnection() throws SQLException {
	return DriverManager.getConnection(URL,USER,PASS);
	
}
}
