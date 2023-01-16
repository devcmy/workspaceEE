package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello.do")
public class HelloServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out= response.getWriter();
		
		 out.print("<!DOCTYPE html>");
		 out.print("<html>");
		 out.print("<head>");
		 out.print("<meta charset=\"UTF-8\">"); // ( \" ) - escpae 시켜줘야한다.
		 out.print("<title>Insert title here</title>");
		 out.print("</head>");
		 out.print("<body>");
		 for(int i=1;i<=5;i++) {
			 	out.print("<h3>Hello Servlet (안녕서블릿) "+ i+"</h3><hr>");
		 }
		 out.print("</body>");
		 out.print("</html>");
		
		
		
		
		
		
		
	}

}
