package com.itwill.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MIMETypeimageResponseServlet
 */
@WebServlet("/response_image.do")
public class MIMETypeimageResponseServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1. 응답객체 MIME타입설정
		 */
		//response.setContentType("image/jpeg");
		//response.setContentType("image/gif");
		response.setContentType("image/jpg"); //확장자 맞춰야한다.
		/*
		 * 2. 브라우저와 연결된 출력스트림 생성
		 */
		OutputStream out = response.getOutputStream(); //image라서 text와 다르게 작성.
		ServletContext context = this.getServletContext();
		String imageFilePath = context.getRealPath("/images/album.jpg"); //this -> MIMETypeimageResponseServlet
		FileInputStream imageFileIn= new FileInputStream(imageFilePath);
		
		while(true) {
			int readByte=imageFileIn.read();
			if(readByte==-1)break;
			out.write(readByte);
		}
		imageFileIn.close();
		out.close();
		
		
		
		
		
	}

	

}
