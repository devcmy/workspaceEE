<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	if(request.getMethod().equalsIgnoreCase("GET")){
		/*
		 * GET방식으로 요청이 들어오면 4.form1.jsp로 방향재지정(redirection) 
		 */
		 response.sendRedirect("4.form1.jsp");
		 
		return;
	}

%>

    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>