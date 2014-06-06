package com.weather.dao;

import java.sql.SQLException;

public class UnsubscribeDao {
	
	public boolean deleteValues(String mobile, String name) throws ClassNotFoundException, SQLException{
		
		DBConnection dbconnection = new DBConnection();
		
		String delete = "Delete from subscribe where contact='"+mobile+"'";
		
		com.mysql.jdbc.Connection connect = (com.mysql.jdbc.Connection) dbconnection.connection();
		
		connect.createStatement().executeUpdate(delete);
		
		return true;
		
	}

}
