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
public class NewStationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	public NewStationServlet() {
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet for NewStationServlet is running.");
		HttpSession session = request.getSession();
		String user = (String)session.getAttribute("user");
		String password = (String)session.getAttribute("password");
		if(user == null)
			response.sendRedirect("/CarDB/Home");
		else
			request.getRequestDispatcher("/public/newStation.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String user = (String)session.getAttribute("user");
		String password = (String)session.getAttribute("password");
		
		String name = request.getParameter("name");
		request.setAttribute("name", name);
		
		String location = request.getParameter("location");
		request.setAttribute("location", location);
		
		Program.insertStation(user, password, name, location);


		
		//TODO: redirect to View Stations page
		
		response.sendRedirect("/CarDB/Home");
		
		
		
	}

}
