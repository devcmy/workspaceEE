package com.itwill.summer.mvc;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;
import com.itwill.guest.controller.GuestListController;
import com.itwill.guest.controller.GuestMainController;
import com.itwill.guest.controller.GuestModifyActionController;
import com.itwill.guest.controller.GuestModifyFormController;
import com.itwill.guest.controller.GuestRemoveActionController;
import com.itwill.guest.controller.GuestViewController;
import com.itwill.guest.controller.GuestWriteActionController;
import com.itwill.guest.controller.GuestWriteFormController;

/*
 * 1. 클라이언트(웹브라우져)의 모든요청을 받는 서블릿작성(front Controller)
 * 2. 확장자가 *.do인 모든클라이언트의 요청(cf.filter는 모든요청)이 서블릿을 실행하도록 web.xml에 url pattern mapping
 *  확장자pattern은 /(slash)를 쓰면 error발생
 * -> . .do 라는 pattern은 내가 결정하는것
   << web.xml >>
    <servlet>
		<servlet-name>dispatcher</servlet-name>
		<servlet-class>com.itwill.summer.mvc.DispatcherServlet</servlet-class>
	</servlet>
	<servlet-mapping>
		<servlet-name>dispatcher</servlet-name>
		<url-pattern>*.do</url-pattern> 
	</servlet-mapping>
 */

public class DispatcherServlet extends HttpServlet {
	private GuestService guestService;
	public DispatcherServlet() throws Exception {
		guestService = new GuestService();
	}


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//processRequest를 get방식으로 실행
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//preocessReqeust를 post방식으로 실행
		processRequest(request, response);
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println(request.getRequestURI()); //요청의url중 context path잘라내기 -> 요청 command
		/*
		 * <<요청 url(command)>>
		/guest_main.do  		
		/guest_list.do			
		/guest_view.do			
		/guest_write_form.do	
		/guest_write_action.do	
		/guest_modify_form.do	
		/guest_modify_action.do	
		/guest_remove_action.do	
		 */
		/*
		 * 1.DispatcherServlet이 클라이언트의 요청URI를 사용해서 요청분석
		 */
		String requestURI = request.getRequestURI();
		String contextPath= request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		
		/*
		 * 2.DispathcerServlet이 클라이언트 요청에 따른 비즈니스 실행[Service객체사용]
		 */
		
		String forwardPath="";
		Controller controller = null;
		
		if(command.equals("/guest_main.do")) {
			/*********************GUEST_MAIN.DO를 처리하는 Controller객체를 생성해줌*********************/
			controller = new GuestMainController();
			/******************************************************/
				
		}else if (command.equals("/guest_list.do")) {
			/*********************GUEST_LIST.DO를 처리하는 Controller객체를 생성해줌*********************/
			controller = new GuestListController();
			/******************************************************/
		}else if (command.equals("/guest_view.do")) {
			/*********************GUEST_VIEW.DO를 처리하는 Controller객체를 생성해줌*********************/
			controller = new GuestViewController();
			/******************************************************/
		}else if (command.equals("/guest_write_form.do")) {
			/*********************GUEST_WRITE_FORM.DO를 처리하는 Controller객체를 생성해줌*********************/
			controller = new GuestWriteFormController();
			/******************************************************/
		}else if (command.equals("/guest_write_action.do")) {
			/*********************GUEST_WRITE_ACTION.DO를 처리하는 Controller객체를 생성해줌*********************/
			controller = new GuestWriteActionController();
			/******************************************************/
		}else if (command.equals("/guest_modify_form.do")) {
			/*********************GUEST_MODIFY_FORM.DO를 처리하는 Controller객체를 생성해줌*********************/
			controller = new GuestModifyFormController();
			/******************************************************/
		}else if (command.equals("/guest_modify_action.do")) {
			/*********************GUEST_MODIFY_ACTION.DO를 처리하는 Controller객체를 생성해줌*********************/
			controller = new GuestModifyActionController();
			/******************************************************/
		}else if (command.equals("/guest_remove_action.do")) {
			/*********************GUEST_REMOVE_ACTION.DO를 처리하는 Controller객체를 생성해줌*********************/
			controller = new GuestRemoveActionController();
			/******************************************************/
		}else {
			forwardPath="forward:/WEB-INF/views/guest_error.jsp";
		}
		
		
		forwardPath = controller.handleRequest(request, response);
		
		/*
		 * 3. DispatcherServlet이 forwardPath를 사용해서 forward 혹은 redirect를 한다.
		 */
			
		/*****************forward or redirect ***********************(forwarding은 여기서함 위에서는 분류)/
		//위에는 forwardpath만 세우고 컨트롤러 아래에서 forward or redirect 로 보냄
		/* 구분(default가 forwarding)
		 * forward  --> forward:/WEB-INF/views/guest_xxx.jsp
		 * redirect --> redirect:guest_xxx.do
		 * redirect에 jsp있으면 무조건 404
		 */
		String[] pathArray = forwardPath.split(":");
		String forwardOrRedirect = pathArray[0];
		String path = pathArray[1];
		
		if(forwardOrRedirect.equals("redirect")) {
			//redirect
			response.sendRedirect(path);
		}else {
			//forwarding
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
			
		}
		/************************************************************/
		
		
		
	}
}
