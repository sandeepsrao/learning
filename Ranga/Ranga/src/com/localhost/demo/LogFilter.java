package com.localhost.demo;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LogFilter implements Filter {
	public void init(FilterConfig config){
		//get init parameter
		String testParam=config.getInitParameter("test-param");
		System.out.println("Test-Param"+testParam);
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
		String ipAddress=request.getRemoteAddr();
		System.out.println("IP Address:"+ipAddress+" Time: "+new Date().toString());
		chain.doFilter(request, response);
	}
	public void destroy(){
		
	}
}
