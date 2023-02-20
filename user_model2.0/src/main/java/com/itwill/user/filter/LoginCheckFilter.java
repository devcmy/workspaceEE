package com.itwill.user.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCheckFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request; //(ServletRequest)가 상위라서, 캐스팅해줘야함
		HttpServletResponse resp = (HttpServletResponse)response; //(ServletResponse)가 상위라서, 캐스팅해줘야함
		
		//System.out.println("LoginCheckFilter-->");
		
		String sUserId = (String)req.getSession().getAttribute("sUserId");
		if(sUserId==null) {
			resp.sendRedirect("user_main.do");
			return;
		}
		chain.doFilter(request, response);
		
		
		
	}

}
