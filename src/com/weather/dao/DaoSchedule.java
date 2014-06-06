package com.weather.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.mysql.jdbc.Statement;

public class DaoSchedule {
	DBConnection dbconnection = new DBConnection();
	
	public String getTime() throws ClassNotFoundException, SQLException
	{
		DateFormat dateFormat = new SimpleDateFormat("HH:mm");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		
		String dataTime = "Select time from subscribe";
		
		com.mysql.jdbc.Connection connect = (com.mysql.jdbc.Connection) dbconnection.connection();
		Statement stmt = (Statement) connect.createStatement();
		
		ResultSet rs = stmt.executeQuery(dataTime);
		String gotTime="";
		String userTime;
		
		while (rs.next()) {
			userTime = rs.getString("time");
			
			if(dateFormat.format(date).equals(userTime)){
				
				gotTime = userTime;
			}
			
			
			
		}
		System.out.println(gotTime);
		return gotTime;
		
		
		
	}
	
	public String getMobile(String time) throws SQLException, ClassNotFoundException{
		
		String dataMobile = "select contact from subscribe where time='"+time+"'";
		com.mysql.jdbc.Connection connect = (com.mysql.jdbc.Connection) dbconnection.connection();
		Statement stmt1 = (Statement) connect.createStatement();
		
		ResultSet rs1 = stmt1.executeQuery(dataMobile);
		
		String userMobile="";
		
		while(rs1.next()){
			
			userMobile = rs1.getString("contact");
			
		}
		
		return userMobile;
		
		
	}
	
public String getCity(String time) throws SQLException, ClassNotFoundException{
		
		String datacity = "select city from subscribe where time='"+time+"'";
		com.mysql.jdbc.Connection connect = (com.mysql.jdbc.Connection) dbconnection.connection();
		Statement stmt2 = (Statement) connect.createStatement();
		
		ResultSet rs2 = stmt2.executeQuery(datacity);
		
		String userCity="";
		
		while(rs2.next()){
			
			userCity = rs2.getString("city");
			
		}
		
		return userCity;
		
		
	}
	
	
	

}
