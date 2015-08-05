package com.jasonradcliffe.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
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
			List<Car> carsList = Program.viewCars(user, password);
			//Car newCar = (Car)carsList.get(0);
			request.setAttribute("viewCarsList", carsList);
			request.getRequestDispatcher("/public/viewCars.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
