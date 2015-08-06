package com.jasonradcliffe.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jasonradcliffe.hibernate.Program;

/**
 * Servlet implementation class LoginServlet
 */

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DoGet method of the loginServlet is running");
		
		request.getRequestDispatcher("/public/index.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("The doPost method of the login servlet is running!!!");
		String username = request.getParameter("user");
		String password = request.getParameter("password");
		
		if(Program.isValidUser(username, password)){
			System.out.println("Valid!");
			
			HttpSession session = request.getSession();
			session.setAttribute("user", username);
			session.setAttribute("password", password);
			//setting session to expire in 20 mins
			session.setMaxInactiveInterval(20*60);
			
			
			//Cookie userName = new Cookie("user", username);
			//response.addCookie(userName);
			
			response.sendRedirect("/CarDB/Main");
			
			//On a successful log in, retrieve all relevant database info that might be called for and store it in
			//the session - an attempt to speed up load times - trying to avoid a database call holding up a page load
			//session.setAttribute("CarsList", Program.getCarsList());
			//session.setAttribute("GasStationList", Program.getStationsList();
			
			
		}
		else{
			System.out.println("FAIL!");
			request.getRequestDispatcher("/public/index.jsp").forward(request, response);
		}
	}

}
