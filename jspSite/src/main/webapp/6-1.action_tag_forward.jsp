<%@page import="com.itwill.student.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	System.out.println("6-1.action_forward.jsp");

	/*
	forwarding
	 - 6-1.action_forwarded.jsp 로 HTTP요청을 보낸다.
	*/
	
	request.setAttribute("id","guard");
	request.setAttribute("name","김경호");
	request.setAttribute("age",34);
	request.setAttribute("student", new Student());
	
	//직접 forwarding기술하는법
	RequestDispatcher rd = 
			request.getRequestDispatcher("6-1.action_tag_forwarded.jsp");
	rd.forward(request, response);
	
	//아래 태그보다는 위에서 직접 기술하는걸 많이 쓴다.


%>
<%-- 태그로 기술
<jsp:forward page="6-1.action_tag_forwarded.jsp"/>
--%>