package com.jasonradcliffe.servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jasonradcliffe.hibernate.FillUp;
import com.jasonradcliffe.hibernate.Program;

/**
 * Servlet implementation class CarServlet
 */



public class Mileage1DataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
    public Mileage1DataServlet() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet for Mileage1ServletData is running.");
		
		
		HttpSession session = request.getSession();
		String user = (String)session.getAttribute("user");
		String password = (String)session.getAttribute("password");
		
		String chartTypeParam = request.getParameter("chartType");
		String jsonObject="";
		DecimalFormat noZeroes = new DecimalFormat("#0");
		DecimalFormat dollaDollaBill = new DecimalFormat("#0.00");
		
		int carID = 1;
		List<FillUp> fillList = Program.getFillUpList(user, password, carID);
		
		if(chartTypeParam.equals("fuelSpendingByYear")){

			FillUp currentFill;
			double[][] yearTotals = new double[20][2];
			int yearCount = 0;
			
			String currentYear = fillList.get(0).getPurchaseDate().toString().substring(0, 4);
			yearTotals[0][0] = Double.parseDouble(currentYear);
			
			for(int index=0; index < fillList.size(); index++){
				currentFill = fillList.get(index);
				String yearString = currentFill.getPurchaseDate().toString().substring(0,4);
				if(!yearString.equals(currentYear)){//the start of a new year
					currentYear = yearString;
					yearCount++;
					yearTotals[yearCount][0] = Double.parseDouble(yearString);
					yearTotals[yearCount][1] = currentFill.getCost();
					
					
				}
				else{//still adding on to the current year's total
					yearTotals[yearCount][1]+=currentFill.getCost();
				}
				
			}
			
			//Adding the values to the JSON string
			
			jsonObject +="[";
			for(int index=0; index < yearCount+1;  index++){
				jsonObject+="{\"year\":\"" + noZeroes.format(yearTotals[index][0]) + "\", \"amount\":" + dollaDollaBill.format(yearTotals[index][1]) + "},";
			}
			jsonObject = jsonObject.substring(0, jsonObject.length() - 1);
			jsonObject += "]";
			System.out.println(jsonObject);
			
			//jsonObject = "[{\"year\": \"2011\", \"amount\":200},{\"year\": \"2012\", \"amount\":340},{\"year\": \"2013\", \"amount\":400}]";
		}
		else if(chartTypeParam.equals("mileageOverTime")){
			
			jsonObject = "[";
			String date = "";
			FillUp currentFill = new FillUp();
			double mileage;
			DecimalFormat formatter = new DecimalFormat("#0.00");
			int gallonsFloor;
			for(int index=0; index < fillList.size(); index++){
				currentFill = fillList.get(index);
				date = currentFill.getPurchaseDate().toString().substring(0,10);
				mileage = currentFill.getTripMileage() / currentFill.getGallonsPurchased();
				gallonsFloor = (int) Math.floor(currentFill.getGallonsPurchased());
				jsonObject+="{\"date\": \"" + date +"\", \"mpg\": " + formatter.format(mileage) + ", \"aValue\":" +  gallonsFloor + "},";
				
				//jsonObject +="{\"date\": \"" + date + "\", \"value\": \"" + formatter.format(mileage) + "\"},";
			}
			jsonObject = jsonObject.substring(0, jsonObject.length() - 1);
			jsonObject += "]";
			
		}
		

		//System.out.println("{\"date\": \"" + date +"\", \"ay\": " + formatter.format(mileage) + ", \"aValue\":" +  gallonsFloor + "},");
		
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print(jsonObject);
		out.flush();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DoPost() for Mileage1Servlet is running!");
	}

}
