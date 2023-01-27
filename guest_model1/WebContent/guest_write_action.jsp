<%@page import="com.itwill.guest.GuestService"%>
<%@page import="com.itwill.guest.Guest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
			/*
			GET방식이면 guest_main.jsp redirection
			0.요청객체encoding설정
			1.파라메타받기(guest_name,guest_email,guest_homepage,guest_title,guest_content)
			  Guest객체생성
			2.GuestService객체생성
			3.GuestService객체 insert(Guest객체) 메쏘드호출
			4.guest_list.jsp로 redirection
			*/
			
			if(request.getMethod().equalsIgnoreCase("GET")){
				response.sendRedirect("guest_main.jsp");
				return;
			}
			request.setCharacterEncoding("UTF-8");
			String name = request.getParameter("guest_name");
			String email = request.getParameter("guest_email");
			String homepage = request.getParameter("guest_homepage");
			String title = request.getParameter("guest_title");
			String content = request.getParameter("guest_content");
			
			Guest guest = new Guest(0,name,null,email,homepage,title,content);
			
			GuestService guestService = new GuestService();
			guestService.insertGuest(guest);
			response.sendRedirect("guest_list.jsp");
			
			
%>