package com.itwill.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class HelloTag extends TagSupport {
	public HelloTag() {
		System.out.println("1. HelloTag기본생성자");
	}
	
	//servlet의 서비스가 실행될때
	
	//tag 시작시 실행되는 메소드
	@Override
	public int doStartTag() throws JspException {
		System.out.println("doStartTag()");
		try {
		JspWriter out = pageContext.getOut();
		String sUserId = (String)pageContext.getSession().getAttribute("sUserId");
		if(sUserId==null) {
			sUserId="GUEST";
		}
		
		out.println(sUserId+" 님 안녕하세요<br>");
		
		
		}catch (IOException e) {
			throw new JspException(e.getMessage());
			//재정의 안하고 exception을 바꾸는법
		}
		return SKIP_BODY;
	}
	//tag 종료시 실행되는 메소드
	@Override
	public int doEndTag() throws JspException {
		System.out.println("doEndTag()");
		try {
			pageContext.getOut().print("<hr>");
		} catch (Exception e) {
			throw new JspException(e.getMessage());
			
		}
		return EVAL_PAGE;
	}
	
	
	
	
}
