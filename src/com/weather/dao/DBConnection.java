package com.weather.dao;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class DBConnection {
	
	public com.mysql.jdbc.Connection connection() throws ClassNotFoundException, SQLException{
		
		
		Statement stmt = null;
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver is Loaded");
		com.mysql.jdbc.Connection con = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/projectfinal","root","root" );
		System.out.println("Connection created");
		 stmt = (Statement) con.createStatement();
		
		return con;
		
		
		
	
}

}
