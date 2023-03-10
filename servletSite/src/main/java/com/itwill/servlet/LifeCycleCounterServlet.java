package com.itwill.servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycleCounterServlet
 */
@WebServlet("/lifeCycle_Counter.do")
public class LifeCycleCounterServlet extends HttpServlet {
	
	private int count;
	
    public LifeCycleCounterServlet() {
    	System.out.println("0.LifeCycleCounterServlet() 기본생성자호출[최초요청시 단 한번호출]객체 주소"+this);
    }
    
    @Override
    	public void init(ServletConfig config) throws ServletException {
    		super.init();
    		System.out.println("1.init()메쏘드 생성자 호출 직후에 단한번 호출[객체 초기화,리소스 획득]");
    	}
    
    

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
		
		//객체에 데이터 저장하는 -> 필드(멤버변수) 선언 //privte int count; (해당메쏘드 안에 생성시 로컬 되서 안됨, 클래스안에서 선언해라)
		out.println("		현재까지의 페이지뷰수 <font color=#0000FF> "+ ++count +" </font> 번입니다");
		out.println("	</center>");
		out.println("</body>");
		out.println("</html>");
	}

	@Override
		public void destroy() {
			System.out.println("3. destroy()메쏘드-->서블릿객체가 메모리에서해제되기직전에 호출된다.[리소스반납]");
		}
	
	
	
	
	
}
