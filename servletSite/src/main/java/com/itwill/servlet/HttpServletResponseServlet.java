package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HttpServletResponseServlet
 */
@WebServlet("/response.do")
public class HttpServletResponseServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		/*
		 * http://192.168.15.31/servletSite/response.do?cmd=1
		 * http://192.168.15.31/servletSite/response.do?cmd=2
		 * http://192.168.15.31/servletSite/response.do?cmd=3
		 * http://192.168.15.31/servletSite/response.do?cmd=  -> empty String
		 * http://192.168.15.31/servletSite/response.do       -> null
		 */
		
		String cmd = request.getParameter("cmd");
		if () {
			
		}
		
	}

}
