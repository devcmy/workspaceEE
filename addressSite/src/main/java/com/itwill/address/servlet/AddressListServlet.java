package com.itwill.address.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class AddressListServlet
 */
@WebServlet("/address_list.do")
public class AddressListServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			/*
			 * 1.AddressService객체생성 
			 * 2.AddressService객체의 selectAll() 메쏘드호출
			 */

			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();

			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset='UTF-8'>");
			out.println("<title>Insert title here</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>[주소록리스트]</h1><hr>");
			out.println("<div>");
			out.println("	<a href='address_insert_form.do'>[주소록쓰기폼]</a>");
			out.println("</div>");
			out.println("<div>");
			out.println("	<ul>");
			out.println("		<li><a href='address_detail.do?no=1'>[1]guard</a></li>");
			out.println("		<li><a href='address_detail.do?no=2'>[2]abcdf</a></li>");
			out.println("	</ul>");
			out.println("</div>");
			out.println("</body>");
			out.println("</html>");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
