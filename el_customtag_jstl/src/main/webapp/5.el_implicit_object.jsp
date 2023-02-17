<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>
<%
	pageContext.setAttribute("url", "page.jsp");
	request.setAttribute("url", "request.jsp");
	session.setAttribute("url", "session.jsp");
	application.setAttribute("url", "application.jsp");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>EL 내장객체(implicit object) 타입은맵이다.</h1><hr>
<ul>
	<li>---pageScope,requestScope,sessionScope,applicationScope---</li>
	<li>${url} <!-- 속성값이 다 같으면 pageContext가 먼저 뜬다. -->
	<li>${pageScope.url} <!-- pageContext--></li>
	<li>${requestScope['url']} <!-- request--></li>
	<li>${sessionScope.url} <!-- request--></li>
	<li>${applicationScope.url} <!-- request--></li>
	<li>--------param---------</li>
	<li>${param}</li>
	<li>${param.id}</li>
	<li>${param.name}</li>
	<li>${param.hobby}</li>
	<li>--------paramValues---------</li>
	<li>${paramValues}</li>
	<li>${paramValues.id[0]}</li>
	<li>${paramValues.name[0]}</li>
	<li>${paramValues.hobby[0]}</li>
	<li>${paramValues.hobby[1]}</li>
	<li>${paramValues.hobby[2]}</li>
	<li>--------cookie---------</li>
	<li>${cookie}</li> <!-- map -->
	<li>${cookie.JSESSIONID}</li> 
	<li>${cookie.JSESSIONID.name}</li> <!-- cookie의 getName -->
	<li>${cookie.JSESSIONID.value}</li> <!-- cookie의 getValue -->
	<li>--------pageContext[빈객체]---------</li>
	<li>${pageContext}</li>
	<li>${pageContext.out}</li>
	<li>${pageContext.request}</li>
	<li>${pageContext.request.method}</li>
	<li>${pageContext.request.contextPath}</li>
	<li>${pageContext.response}</li>
	<li>${pageContext.servletContext}</li>
	<li>${pageContext.page}</li>
	<li>${pageContext.session}</li>
	<li>${pageContext.session.maxInactiveInterval}</li>
	<li>${pageContext.session.creationTime}</li>
	<li>${pageContext.servletConfig}</li>
	<li>${pageContext.servletConfig}</li>
	
</ul>	

	
	
	
	
	    
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</ul>
</body>
</html>