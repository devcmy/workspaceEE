package com.itwill.guest.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;
/**
 * Servlet implementation class GuestListServlet
 */
@WebServlet("/guest_list.do")
public class GuestListServlet extends HttpServlet {
	private GuestService guestService;
	public GuestListServlet() throws Exception {
		guestService=new GuestService();
	}
	

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forwardPath = "";
		try {
			//guest_list.jsp에 있는 자바코드를 여기로 이동(jsp는 출력만 담당)
		forwardPath="forward:/WEB-INF/views/guest_list.jsp";
		GuestService guestService=new GuestService();
		List<Guest> guestList = guestService.findAll(); //여기서 throws 예외 던지면 재정의위반
		request.setAttribute("userList", guestList);
		}catch (Exception e) {
			e.printStackTrace();
			forwardPath="forward:/WEB-INF/views/guest_error.jsp";
		}
		/*****************forward or redirect ***********************/
		//위에는 forwardpath만 세우고 컨트롤러 아래에서 forward or redirect 로 보냄
		/* 구분(default가 forwarding)
		 * forward  --> forward:/WEB-INF/views/guest_xxx.jsp
		 * redirect --> redirect:guest_xxx.do
		 * redirect에 jsp있으면 무조건 404
		 */
		String[] pathArray = forwardPath.split(":");
		String forwardOrRedirect = pathArray[0];
		String path = pathArray[1];
		
		if(forwardOrRedirect.equals("redirect")) {
			//redirect
			response.sendRedirect(path);
		}else {
			//forwarding
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
			
		}
		/************************************************************/
		
		//포워딩하고, 필요시에 redirection함(데이터전달할필요가 없을경우 redirection사용)
	}

}
