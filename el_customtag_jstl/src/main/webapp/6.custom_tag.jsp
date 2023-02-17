<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="itwill" uri="http://www.itwill.co.kr/jsp/simpleTag" %>
<%
	session.setAttribute("sUserId", "jasper.c");
	request.setAttribute("name", "현빈");
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body >
<h1>custom tag[사용자정의태그]</h1><hr/>
---------------hello tag----------------------<br>
<itwill:hello/>
<itwill:hello/>
---------------helloAttr tag----------------------<br>
<!-- 외부에서 속성이용해서 넣어줌 -->
<itwill:helloAttr irum="김경호"/>
<itwill:helloAttr irum="공유"/>
<itwill:helloAttr irum="${name}"/>
<itwill:helloAttr irum="${sUserId}"/>
---------------if tag[body]----------------------<br>
<itwill:if test="true">
	반드시 실행<br>
</itwill:if>
<itwill:if test="false">
	반드시 실행X<br>
</itwill:if>
<itwill:if test="${sUserId == null}">
	GUEST님 안녕하세요<br>
</itwill:if>
<itwill:if test="${sUserId != null}">
	${sUserId} 님 안녕하세요<br>
</itwill:if>

<itwill:if test="${empty sUserId}">
	<a href="user_login_form.jsp">로그인</a>
</itwill:if>
<itwill:if test="${!empty sUserId}">
	<a href="user_logout_form.jsp">${sUserId}님 로그아웃</a>
</itwill:if>











</body>
</html>