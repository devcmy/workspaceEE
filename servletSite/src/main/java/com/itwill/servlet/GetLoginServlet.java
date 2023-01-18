package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetLoginServlet
 */
@WebServlet("/get_login.do")
public class GetLoginServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
	/*
	 * 1. 요청시 전송되는 파라메타 받기
	 *  - 파라메타이름은 input element의 이름과 같다.
	   		아이디:<input type="text" name="id"><br/>
			패에쓰:<input type="password" name="pass"><br/>
	 */
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	if(id==null || id.equals("")||pass==null||pass.equals("")) {
		response.sendRedirect("05-01.login_get.html");
		return;
	} //값이 하나 없으면 로그인 페이지(05-01.login_get.html)로 이동(방어코드 작성)
	
	/*
	 * 로그인업무실행(Service객체사용) -> DB쓰는대신에 임시로 사용
	 * ----------
	 *  id  |pass
	 * ----------
	 *  xxxx|1111
	 *  -----------
	 *  yyyy|2222
	 *  ---------
	 */
	boolean isMember1 = id.equals("xxxx") && pass.equals("1111");
	boolean isMember2 = id.equals("yyyy") && pass.equals("2222");
	
	out.print("<h1>GET 로그인결과</h1><hr>");
	if(isMember1 || isMember2 ) {
		//로그인성공
		out.println("<h3>"+id+"님 로그인성공</h3><hr>");
		out.println("<a href='index.html'>메인으로</a>");
		}else {
		//로그인 실패
		out.println("<h3>"+id+"님 로그인실패</h3><hr>");
		out.println("<a href='05-01.login_get.html'>다시로그인</a>");
		
	}
	
	
	
		
		
	}

}
