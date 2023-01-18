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
@WebServlet("/post_login.do")
public class PostLoginServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("05-02.login_post.html");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		response.sendRedirect("05-02.login_post.html");
		return;
	} //값이 하나 없으면 로그인 페이지(05-02.login_POST.html)로 이동(방어코드 작성)
	
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
	
	out.print("<h1>POST 로그인결과</h1><hr>");
	if(isMember1 || isMember2 ) {
		//로그인성공
		out.println("<h3>"+id+"님 로그인성공</h3><hr>");
		out.println("<a href='index.html'>메인으로</a>");
		}else {
		//로그인 실패
		//response.sendRedirect("05-01.login_get.html"); (안 쓴다)//-> 왜 로그인창이 뜨는지 이유를 모른다(이유:바로 로그인창을뜨기때문에 왜 뜨는지 모름)
		out.println("<h3>"+id+"님 로그인실패</h3><hr>");
		out.println("<a href='05-02.login_post.html'>다시로그인</a>");
	}
	
	
	
		
		
	}

}
