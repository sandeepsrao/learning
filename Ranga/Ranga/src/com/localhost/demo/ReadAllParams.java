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
 * Servlet implementation class ReadAllParams
 */
@WebServlet("/ReadAllParams")
public class ReadAllParams extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadAllParams() {
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
				"<h1>Read all Params</h1><table><tr><th>Param Name</th><th>Param Value</th></tr>");
		Enumeration paramNames=request.getParameterNames();
		while(paramNames.hasMoreElements()){
			String paramName=(String)paramNames.nextElement();
			out.println("<tr><td>"+paramName+"</td><td>");
			String[] paramValues=request.getParameterValues(paramName);
			if(paramValues.length == 1){
				String paramValue=paramValues[0];
				if(paramValue.length() == 0){
					out.println("No Value");
				}
				else
					out.println(paramValue);
			}
			else{
				out.println("<div style='text-decoration:none;display:block;color:#666666'>");
				for(String item : paramValues){
					out.println("<span>"+item+"</span>");
				}
				out.println("</div>");
			}
			out.println("</td></tr>");
		}
		out.println("</table></body></html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
