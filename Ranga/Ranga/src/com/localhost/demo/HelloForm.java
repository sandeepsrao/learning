package com.localhost.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloForm
 */
@WebServlet("/HelloForm")
public class HelloForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cookie maths = new Cookie("maths",request.getParameter("maths"));
		Cookie physics = new Cookie("physics", request.getParameter("physics"));
		Cookie chemistry = new Cookie("chemistry", request.getParameter("chemistry"));
		
		maths.setMaxAge(60*60*24);
		physics.setMaxAge(60*60*24);
		chemistry.setMaxAge(60*60*24);
		
		response.addCookie(maths);
		response.addCookie(physics);
		response.addCookie(chemistry);
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		String title="Using Get method to Read Form Data";
		String doctype="<!DOCTYPE html>";
		out.println(doctype+
					"<html>"
					+ "<head><title>"+title+"</title></head>"
					+"<body>"
					+ "<h1>"+title+"</h1>"
					+"<ul><li><b></b>"+request.getParameter("maths")+"</li><li><b>"+request.getParameter("physics")+"</b></li><li><b>"+request.getParameter("chemistry")+"</b></li></ul>"
					+ "</body>"
					+ "</html>"
				);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		doGet(request, response);
	}

}
