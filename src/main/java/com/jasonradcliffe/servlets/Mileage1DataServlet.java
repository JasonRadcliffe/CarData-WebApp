package com.jasonradcliffe.servlets;


import com.jasonradcliffe.hibernate.FillUp;
import com.jasonradcliffe.hibernate.Program;
import com.jasonradcliffe.hibernate.ServiceStation;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		System.out.println("doGet for Mileage1Servlet is running.");
		
		
		HttpSession session = request.getSession();
		String user = (String)session.getAttribute("user");
		String password = (String)session.getAttribute("password");
		int carID = 1;
		//request.getRequestDispatcher("/public/newCar.jsp").forward(request, response);
		
		List<FillUp> fillList = Program.getFillUpList(user, password, carID);
		String jsonObject = "[";
		String date = "";
		FillUp currentFill = new FillUp();
		double mileage;
		int gallonsFloor;
		for(int index=0; index < fillList.size(); index++){
			currentFill = fillList.get(index);
			date = currentFill.getPurchaseDate().toString().substring(0,10);
			mileage = currentFill.getTripMileage() / currentFill.getGallonsPurchased();
			gallonsFloor = (int) Math.floor(currentFill.getGallonsPurchased());
			jsonObject+="{\"date\": \"" + date +"\", \"ay\": " + mileage + ", \"aValue\":" +  gallonsFloor + "},";
		}
		jsonObject = jsonObject.substring(0, jsonObject.length() - 1);
		jsonObject += "]";
		System.out.println(jsonObject);
		
		//String jsonObject = "[{\"category\": \"2013-08-24\", \"value1\": 417, \"value2\": 127}, {\"category\": \"2013-08-25\",\"value1\": 222,\"value2\": 356}]";
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
