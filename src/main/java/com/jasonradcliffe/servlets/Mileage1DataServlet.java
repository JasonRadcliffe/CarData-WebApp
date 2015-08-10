package com.jasonradcliffe.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		
		
		String jsonObject = "[{\"category\": \"2013-08-24\", \"value1\": 417, \"value2\": 127}, {\"category\": \"2013-08-25\",\"value1\": 417,\"value2\": 356}]";
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
