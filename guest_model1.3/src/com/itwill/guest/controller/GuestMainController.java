package com.itwill.guest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.summer.mvc.Controller;

/*
 * 	web component가 아닌, object의 자식이며, java class.(의존성줄이기위해 사용)
 * - 클라이언트요청을 처리하는 비즈니스로직을 담고있는 객체
 * - DispatcherServlet객체가 호출하는 handleRequest메쏘드를가짐
 * - handleRequest메쏘드가호출되면 DispatcherServlet객체에 !forwardPath!를 반환해줌
 * 실행의 주체 : DispatcherServlet
 */
public class GuestMainController implements Controller {
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath="forward:/WEB-INF/views/guest_main.jsp";
		return forwardPath;
	}
}
