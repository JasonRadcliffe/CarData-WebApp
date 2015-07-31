package com.jasonradcliffe.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jasonradcliffe.hibernate.Program;

/**
 * Servlet implementation class CarServlet
 */
public class NewCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewCarServlet() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet for CarServlet is running.");
		HttpSession session = request.getSession();
		String user = (String)session.getAttribute("user");
		String password = (String)session.getAttribute("password");
		if(user == null)
			response.sendRedirect("/CarDB/Home");
		else
			request.getRequestDispatcher("/public/newCar.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String user = (String)session.getAttribute("user");
		String password = (String)session.getAttribute("password");
		
		
		String licensePlate = request.getParameter("licensePlate");
		request.setAttribute("licensePlate", licensePlate);
		
		String make = request.getParameter("make");
		request.setAttribute("make", make);
		
		String model = request.getParameter("model");
		request.setAttribute("model", model);
		
		int modelYear = Integer.parseInt(request.getParameter("modelYear"));
		request.setAttribute("modelYear", modelYear);
		
		double odometerReading = Double.parseDouble(request.getParameter("odometerReading"));
		request.setAttribute("odometerReading", odometerReading);
		
		Program.insertCar(user, password, licensePlate, make, model, modelYear, odometerReading);


		response.sendRedirect("/CarDB/Home");
		
		
	}

}
