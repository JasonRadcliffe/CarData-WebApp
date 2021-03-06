package com.jasonradcliffe.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jasonradcliffe.hibernate.Car;
import com.jasonradcliffe.hibernate.Program;
import com.jasonradcliffe.hibernate.ServiceStation;



public class NewRepairServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewRepairServlet() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String user = (String)session.getAttribute("user");
		String password = (String)session.getAttribute("password");
		if(user  == null)
			response.sendRedirect("/CarDB/Home");
		else{
			//Fetch the list of available cars
			List<Car> carList = Program.getCarsList(user, password);
			String carOptions="<option>Select One</option>";
			Car currentCar;
			String carModel;
			int carYear;
			int carID;
			for(int index=0; index < carList.size(); index++){
				currentCar = carList.get(index);
				carModel = currentCar.getModel();
				carYear = currentCar.getModelYear();
				carID = currentCar.getCarID();
				carOptions+="<option value=\"" + carID + "\">" +  carModel + " - \'" + carYear % 100 + "</option>";
			}
			
			
			//Pushing across the list of cars
			request.setAttribute("carOptions", carOptions);
			
			
			//Fetch the list of available stations
			List<ServiceStation> stationList = Program.getStationsList(user, password);
			String stationOptions="<option>Select One</option>";
			ServiceStation currentStation;
			String stationName;
			String stationLoc;
			int stationID;
			int endPosition; //endPosition stuff is to prevent trying to access more of a string than there is - in the case of a super short address string
			for(int index=0; index < stationList.size(); index++){
				currentStation = stationList.get(index);
				stationName = currentStation.getName();
				stationLoc = currentStation.getLocation();
				stationID = currentStation.getStationID();
				if(stationLoc.length() < 15){
					endPosition = stationLoc.length() - 1; 
				}
				else{
					endPosition = 15;
				}
				stationOptions+="<option value=\"" + stationID + "\">" +  stationName + " - " + stationLoc.substring(0, endPosition)  + "...</option>";
			}
			
			
			//Pushing across the list of cars
			request.setAttribute("stationOptions", stationOptions);
			
					
			//Redirect to the .jsp page
			request.getRequestDispatcher("/public/newRepair.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String user = (String)session.getAttribute("user");
		String password = (String)session.getAttribute("password");
		
		int carID = Integer.parseInt(request.getParameter("car"));
		request.setAttribute("carID", carID);
		
		int stationID = Integer.parseInt(request.getParameter("station"));
		request.setAttribute("stationID", stationID);
		
		Date purchaseDate = null;
		try {
			purchaseDate =new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("purchaseDate"));
		} catch (ParseException e) {
			System.out.println("problem parsing the date");
		}
		
		
		double odometerReading = Double.parseDouble(request.getParameter("odometerReading"));

		double cost = Double.parseDouble(request.getParameter("cost"));
		
		String description = request.getParameter("description");
		
		String mechanicName = request.getParameter("mechanicName");


		
		System.out.println("Trying the insert.");
		Program.insertRepair(user, password, carID, stationID, purchaseDate, odometerReading, cost, description, mechanicName);
		System.out.println("We should, in theory, have finished the insert.");
		
		response.sendRedirect("/CarDB/Main");
		
	}

}
