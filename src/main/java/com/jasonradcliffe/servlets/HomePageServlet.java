package com.jasonradcliffe.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CarServlet
 */
public class HomePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
    public HomePageServlet() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet for homepage is running.");
		HttpSession session = request.getSession();


		//getting the userID from Program, via LoginServlet
		int userID = (Integer)session.getAttribute("userID");
		System.out.println("We seem to have gotten a value:" + userID);
		request.setAttribute("userID", userID);
		
		if(session.getAttribute("user") == null)
			response.sendRedirect("/CarDB/Home");
		else
			request.getRequestDispatcher("/public/main.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DoPost() for CarDBServlet is running!");
	}

}
