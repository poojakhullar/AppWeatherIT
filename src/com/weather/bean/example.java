package com.weather.bean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		DateFormat dateFormat = new SimpleDateFormat("HH:mm");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		if(dateFormat.format(date).equals("16:36"))
		{
			System.out.println("same");
		}
		else{
			System.out.println("sorry");
		}

	}

}
