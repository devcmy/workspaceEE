<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="7-2.default_session_login_check.jspf" %>

<%
   /*
   세션객체무효화
   */
   session.invalidate();

   request.getSession(true); //세션id,세션객체 다시만들어짐

   response.sendRedirect("7-2.default_session_login_form.jsp");	
%>