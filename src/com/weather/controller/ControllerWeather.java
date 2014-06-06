package com.weather.controller;

import java.io.IOException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.clockworksms.ClockWorkSmsService;
import com.clockworksms.ClockworkException;
import com.clockworksms.ClockworkSmsResult;
import com.clockworksms.SMS;
import com.weather.bean.WeatherBean;

/**
 * Servlet implementation class ControllerWeather
 */
public class ControllerWeather extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerWeather() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			
			WeatherBean wbean = new WeatherBean();
			
			String city = request.getParameter("tempcity");
			String mobile = request.getParameter("mobile");
			System.out.println(city);
			//String str = "this is fun";
			String newcity = city.replaceAll(" ", "%20").trim();
			System.out.println(newcity);
			
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db
					.parse(new URL(
							"http://api.worldweatheronline.com/free/v1/weather.ashx?q="+newcity+"&format=xml&num_of_days=3&key=543hvpvzhz3ubbr99vkm88f7")
							.openStream());

			doc.getDocumentElement().normalize();

			// System.out.println("Root element :" +
			// doc.getDocumentElement().getNodeName());

			NodeList nList = doc.getElementsByTagName("current_condition");

			NodeList nList1 = doc.getElementsByTagName("request");

			// System.out.println(nList);

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = ((NodeList) nList).item(temp);
				Node nNode1 = ((NodeList) nList1).item(temp);

				// System.out.println("\nCurrent Element :" +
				// nNode.getNodeName());

				// System.out.println("\nCurrent Element :" +
				// nNode1.getNodeName());
				if (nNode1.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode1;

//					System.out.println("Your City : "
//							+ eElement.getElementsByTagName("query").item(0)
//									.getTextContent());
					wbean.setCity(eElement.getElementsByTagName("query").item(0)
									.getTextContent());

				}

				System.out.println("");

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
					
					wbean.setTempC(eElement.getElementsByTagName("temp_C").item(0).getTextContent());
					
					wbean.setObstime(eElement.getElementsByTagName("observation_time")
									.item(0).getTextContent());
					
					wbean.setTempF(eElement.getElementsByTagName("temp_F").item(0)
							.getTextContent());
					
					wbean.setCloudcover(eElement.getElementsByTagName("cloudcover")
									.item(0).getTextContent());
					
					wbean.setHumidity(eElement.getElementsByTagName("humidity").item(0)
									.getTextContent());
					
					wbean.setDescription(eElement.getElementsByTagName("weatherDesc")
									.item(0).getTextContent());
					
					HttpSession session = request.getSession();
					
					session.setAttribute("weather", wbean);
					
					
					try {
						ClockWorkSmsService clockWorkSmsService = new ClockWorkSmsService("e697f428c4ef2bb46c71324ac11aedbffd5b4c03");
						
				         SMS sms = new SMS(mobile, "Hi , Temperature at"+wbean.getCity()+"is"+wbean.getTempF()+" F. Have a nice day!!"); 
				         System.out.println(mobile);
				         ClockworkSmsResult result = clockWorkSmsService.send(sms);
				 
				         if(result.isSuccess())
				         {
				            System.out.println("Sent with ID: " + result.getId());
				            //response.sendRedirect("WeatherInfo.jsp");
				         }
				         else
				         {
				            System.out.println("Error: " + result.getErrorMessage());
				         }
				      }
						
						
					catch (ClockworkException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					//response.sendRedirect("index.html");
					response.sendRedirect("WeatherInfo.jsp");
					

				}

			}
		} catch (ParserConfigurationException e) {
		} catch (SAXException e) {
		} catch (IOException e) {
		}


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
