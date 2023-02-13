package com.itwill.guest.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GuestMainServlet
 */
@WebServlet("/guest_main.do")
public class GuestMainServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 클라이언트가 직접 요청x -> web-inf/views안에 넣음 (모든 jsp요청오면 404뜸)
		 */
		String forwardPath="/WEB-INF/views/guest_main.jsp";
		RequestDispatcher rd = 
				request.getRequestDispatcher(forwardPath);
		rd.forward(request, response);
		
	}

}
