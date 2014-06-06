package com.weather.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.imageio.spi.RegisterableService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.weather.bean.RegistrationBean;
import com.weather.dao.RegistrationDao;

/**
 * Servlet implementation class RegisterFinal
 */
public class RegisterFinal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterFinal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		RegistrationBean RegBean =  (RegistrationBean) session.getAttribute("register1");
		
		String username = RegBean.getName();
		String contactno = RegBean.getContactno();
		String password = RegBean.getPassword();
		
		String city = request.getParameter("city");
		String time = request.getParameter("time");
		
		RegistrationDao rdao = new RegistrationDao();
	
		Boolean bool;
		
			try {
				bool = rdao.insertValues(username, city, contactno, password, time);
				
				if(bool){
					
					response.sendRedirect("success.jsp");
				}
				else{
					
					response.sendRedirect("failure.jsp");
				}
				
			} 
			catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
