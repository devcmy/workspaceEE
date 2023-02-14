package com.itwill.guest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;

public class GuestListController {
	private GuestService guestService;
	public GuestListController() {
		guestService = new GuestService();
	}	
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
			String forwardPath="";
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
			return forwardPath;
	}

}
