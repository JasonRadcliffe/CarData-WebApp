package com.jasonradcliffe.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jasonradcliffe.hibernate.Car;
import com.jasonradcliffe.hibernate.Program;

/**
 * Servlet implementation class CarServlet
 */
public class ViewCarsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewCarsServlet() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet for ViewCarsServlet is running.");
		HttpSession session = request.getSession();
		String user = (String)session.getAttribute("user");
		String password = (String)session.getAttribute("password");
		
		if(user == null)
			response.sendRedirect("/CarDB/Home");
		else{
			ArrayList<Car> carsList = Program.viewCars(user, password);
			System.out.println("Retrieved: " + carsList.size() + " cars.");
			request.getRequestDispatcher("/public/viewCars.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
