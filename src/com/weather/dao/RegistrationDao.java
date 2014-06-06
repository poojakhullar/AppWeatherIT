package com.weather.dao;

import java.sql.SQLException;

public class RegistrationDao {
	
	DBConnection dbconnection = new DBConnection();
	
	public boolean insertValues(String name, String city, String mobile, String pwd, String time) throws ClassNotFoundException, SQLException{
		
		System.out.println("in dao");
		
		String pass = pwd;
		
		
			
			String insert = "INSERT INTO subscribe (username,city,contact,pwd,time) VALUES ('"+name+"','"+city+"','"+mobile+"','"+pass+"','"+time+"')";
			
			//String insert1 = "INSERT INTO registration (name,city,mobile,pwd) VALUES ('prateek','pune','123456789','1234')";
			
			com.mysql.jdbc.Connection connect = (com.mysql.jdbc.Connection) dbconnection.connection();
			System.out.println("inserting values");
			
			connect.createStatement().executeUpdate(insert);
		
		
		return true;
		
		
	}

}
