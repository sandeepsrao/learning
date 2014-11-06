package com.localhost.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HeaderNames
 */
@WebServlet(description = "gets the header parameters", urlPatterns = { "/HeaderNames" })
public class HeaderNames extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HeaderNames() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		String doctype="<!DOCTYPE html>";
		out.println(doctype+
				"<html>"+
				"<head><title>Read all Params</title></head>"+
				"<body>"+
				"<h1>Header Params</h1><table><tr><th>Header Name</th><th>Header Value</th></tr>");
		
		Enumeration headerNames=request.getHeaderNames();
		while(headerNames.hasMoreElements()){
			String paramName=(String)headerNames.nextElement();
			out.println("<tr><td>"+paramName+"</td><td>");
			String paramValue=request.getHeader(paramName);
			out.println(paramValue+"</td></tr>");
		}
		out.println("</table></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
