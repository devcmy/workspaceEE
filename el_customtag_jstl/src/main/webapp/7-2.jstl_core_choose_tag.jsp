<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	session.setAttribute("sUserId", "admin");
	session.setAttribute("sUserId", "test");
	session.setAttribute("level", 5); //레벨은 1~5 사이의 정수
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>JSTL core choose tag</h1><hr>
<c:choose>
	<c:when test="${level==1}">
	초보시군요[${level}]<br>
	</c:when>
	<c:when test="${level==2}">
	중수시군요[${level}]<br>
	</c:when>
	<c:when test="${level==3}">
	고수시군요[${level}]<br>
	</c:when>
	<c:when test="${level>3 && level<=5}">
	초고수시군요[${level}]<br>
	</c:when>
	<c:otherwise>
	레벨은 1~5사이의 정수입니다.<br>
	</c:otherwise>
</c:choose>















</body>
</html>