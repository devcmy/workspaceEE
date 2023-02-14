package com.itwill.guest.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;

/**
 * Servlet implementation class GuestViewServlet
 */
@WebServlet("/guest_view.do")
public class GuestViewServlet extends HttpServlet {
	private GuestService guestService;
	public GuestViewServlet() throws Exception {
		guestService = new GuestService();
	}
	/*
	 * 0.요청객체encoding설정
	 * 1.gust_no 파라메타받기
	 * 2.GuestService객체생성
	 * 3.GuestService객체 selectByNo(guest_no) 메쏘드호출
	 * */
	//parameter가없으니 guest_main.do로 redirection된다.
	//절대출력x forwarding or redirecting만 한다.

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forwardPath = "";
		
		try {
			String guest_noStr = request.getParameter("guest_no");
			if (guest_noStr == null || guest_noStr.equals("")) {
				//response.sendRedirect("guest_main.do");
				forwardPath="redirect:guest_main.do";
			}else {
			Guest guest = guestService.findByNo(Integer.parseInt(guest_noStr));
			request.setAttribute("guest", guest);//넘겨주기
			forwardPath = "forward:/WEB-INF/views/guest_view.jsp";
			}
		} catch (Exception e) {
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
		
		
	}
		
}

