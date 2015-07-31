package com.jasonradcliffe.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jasonradcliffe.hibernate.Car;
import com.jasonradcliffe.hibernate.Program;
import com.jasonradcliffe.hibernate.ServiceStation;



public class NewFillUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewFillUpServlet() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("user") == null)
			response.sendRedirect("/CarDB/Home");
		else{			
			//Fetch the list of available cars
			ArrayList<Car> carList = Program.getCarsList();
			String carOptions="<option>Select One</option>";
			
			for(int index=1; index < carList.size(); index++){//using < rather than <= since the list has a dummy value at list[0]
				carOptions+="<option value=\"" + index + "\">" +  carList.get(index).getModel() + "</option>";
			}
			
			
			//Pushing across the list of cars
			request.setAttribute("carOptions", carOptions);
			
			
			//Fetch the list of available stations
			ArrayList<ServiceStation> stationList = Program.getStationsList("Gas", true);
			String stationOptions="<option>Select One</option>";
			
			for(int index=1; index < stationList.size(); index++){//using < rather than <= since the list has a dummy value at list[0]
				stationOptions+="<option value=\"" + index + "\">" +  stationList.get(index).getName() + " - " + stationList.get(index).getLocation()  + "</option>";
			}
			
			
			//Pushing across the list of cars
			request.setAttribute("stationOptions", stationOptions);
			
					
			//Redirect to the .jsp page
			request.getRequestDispatcher("/public/newFillUp.jsp").forward(request, response);
		}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int carID = Integer.parseInt(request.getParameter("car"));
		
		int stationID = Integer.parseInt(request.getParameter("station"));
		
		Date purchaseDate = null;
		try {
			purchaseDate =new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("purchaseDate"));
		} catch (ParseException e) {
			System.out.println("problem parsing the date");
		}
		
		double gallonsPurchased = Double.parseDouble(request.getParameter("gallonsPurchased"));
		
		
		boolean isFillUp = Boolean.parseBoolean(request.getParameter("isFillUp"));
		
		double tripMileage = Double.parseDouble(request.getParameter("tripMileage"));
		
		double odometerReading = Double.parseDouble(request.getParameter("odometerReading"));

		double cost = Double.parseDouble(request.getParameter("cost"));
		


		
		//System.out.println("Trying the insert.");
		Program.insertFillUp(carID, stationID, purchaseDate, gallonsPurchased, isFillUp, tripMileage, odometerReading, cost);
		//System.out.println("We should, in theory, have finished the insert.");
		
		response.sendRedirect("/CarDB/Main");
		
	}

}
