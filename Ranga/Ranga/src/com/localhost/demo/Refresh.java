package com.localhost.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Refresh
 */
@WebServlet("/Refresh")
public class Refresh extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Refresh() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Set refresh, autoload time as 5 seconds
		response.setIntHeader("Refresh", 5);
		response.setContentType("text/html");
		
		//Get current time
		Calendar calendar=new GregorianCalendar();
		String am_pm;
		int hour=calendar.get(Calendar.HOUR);
		int min=calendar.get(Calendar.MINUTE);
		int sec=calendar.get(Calendar.SECOND);
		if(calendar.get(Calendar.AM_PM)==0)
			am_pm="AM";
		else
			am_pm="PM";
		String CT=hour+":"+min+":"+sec+" "+am_pm;
		PrintWriter out=response.getWriter();
		String docType="<!DOCTYPE html>";
		out.println(docType+
				"<html><head><title>Refresh Header Page</title></head><body>"
				+ "<h1 style='align:center'>Refresh Header</h1>"
				+ "<p>Current Time:"
				+ CT+"</p></body></html>"
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
