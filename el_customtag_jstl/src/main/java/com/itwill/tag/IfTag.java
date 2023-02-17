package com.itwill.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class IfTag extends TagSupport {
	
	private boolean test;
	
	
	
	public void setTest(boolean test) {
		this.test = test;
	}

	@Override
	public int doStartTag() throws JspException {
		if(test) { //body를 실행시켜서 포함시켜라
			return EVAL_BODY_INCLUDE;
		}else {	//body를 무시해라
			return SKIP_BODY;
		}
	}
	
	@Override
	public int doEndTag() throws JspException {
		return EVAL_PAGE;
		//page 계속 실행해
	}
}
