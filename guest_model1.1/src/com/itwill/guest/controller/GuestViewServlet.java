package com.itwill.guest.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GuestViewServlet
 */
@WebServlet("/guest_view.do")
public class GuestViewServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 클라이언트가 직접 요청x -> web-inf/views안에 넣음 (모든 jsp요청오면 404뜸)
		 * servlet 통해서만 가능 jsp에서는 직접호출x
		 */
		String forwardPath="/WEB-INF/views/guest_view.jsp";
		RequestDispatcher rd = 
				request.getRequestDispatcher(forwardPath);
		rd.forward(request, response);
	}

}
