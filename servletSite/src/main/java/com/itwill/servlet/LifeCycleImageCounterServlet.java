package com.itwill.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycleCounterServlet
 */
@WebServlet("/lifeCycle_image_Counter.do")
public class LifeCycleImageCounterServlet extends HttpServlet {
	
	private int count;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		System.out.println("2.service메쏘드가 실행");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body bgcolor=#40e0d0 style=\"font-size: 9pt; line-height: 140%;\">");
		out.println("	<center>");
		
		out.println("		현재까지의 페이지뷰수 <font color=#0000FF> "+ ++count +" </font> 번입니다");
		//객체에 데이터 저장하는 -> 필드(멤버변수) 선언 //privte int count; (해당메쏘드 안에 생성시 로컬 되서 안됨, 클래스안에서 선언해라)
		out.println("		현재까지의 페이지뷰수 <font color=#0000FF> "+ imagecount(count) +" </font> 번입니다");
		out.println("	</center>");
		out.println("</body>");
		out.println("</html>");
	}
	
  	public String imagecount(int count) {
		String count1 =Integer.toString(count);
		String text="";
		for (int i = 0; i < count1.length(); i++) {
			text=text.concat("<img src='images/"+count1.charAt(i)+".png'>");
		}
		
		return text;
	} 
	/*
	public String imagecount(int count) {
		String count1 =Integer.toString(count);
		String text="";
		for (int i = 0; i < count1.length(); i++) {
			text=text.concat("<img src='images/"+String.valueOf(count).charAt(i)+".png'>");
		}
		
		return text;
	}
*/

	
	
	
	
	
}
