package com.localhost.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ErrorHandler
 */
@WebServlet("/ErrorHandler")
public class ErrorHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ErrorHandler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Throwable throwable = (Throwable)request.getAttribute("javax.servlet.error.exception");
		Integer statusCode = (Integer)request.getAttribute("javax.servlet.error.status_code");
		String servletName = (String)request.getAttribute("javax.servlet.error.servlet_name");
		if(servletName == null){
			servletName = "Unknown";
		}
		String requestUri = (String) request.getAttribute("javax.servlet.error.request_uri");
		if(requestUri == null){
			requestUri = "Unknown";
		}
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html><html><head><title>Error Handler Page</title></head><body>");
		if(throwable == null && statusCode == null){
			out.println("Error information missing.");
			out.println("Please return to the <a href='http://localhost:8080/'>Home Page</a>");
		}
		else if(statusCode != null){
			out.println("The status code:"+statusCode);
		}
		else{
			out.println("<h2>Error information</h2>");
			out.println("Servlet Name: "+servletName);
			out.println("Exception Type: "+throwable.getClass().getName());
			out.println("Request URI: "+requestUri);
			out.println("Exception Message: "+throwable.getMessage());
			out.println("</body></html>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
