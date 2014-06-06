package com.weather.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.weather.bean.RegistrationBean;
import com.weather.dao.RegistrationDao;

/**
 * Servlet implementation class RegistrationController
 */
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//response.sendRedirect("register2.html");
		//response.sendRedirect("index.html");
		
		HttpSession session = request.getSession();
		
		RegistrationBean rbean = new RegistrationBean();
		String name = request.getParameter("name");
		//String city = request.getParameter("city");
		String mobile = request.getParameter("contactno");
		String pwd = request.getParameter("passwrd");
		String cpwd = request.getParameter("cpasswrd");
		
		if(pwd.equals(cpwd)){
		
		rbean.setName(name);
		rbean.setContactno(mobile);
		rbean.setPassword(pwd);
		
		session.setAttribute("register1", rbean);
		
		response.sendRedirect("register2.html");
		
		}
		
//		
//		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
