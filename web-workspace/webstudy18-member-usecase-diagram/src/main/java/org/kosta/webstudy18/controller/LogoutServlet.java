package org.kosta.webstudy18.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//url은 한번만 사용되므로 굳이 변수를 만들어서 대입할 필요없다. url직접 입력
		String url = null;
		//getSession(false) : 기존 세션이 있으면 기존 세션을 리턴, 기존 세션이 없으면 null 반환 
		//					  세션 없으면 reponse로 반환해주기만 하면 됨 
		HttpSession session = request.getSession(false);
		if(session != null) {
			session.invalidate();//세션을 무효화 한다
			url = "index.jsp";//
		}
		//바깥에서 아래 코드를 실행해야 한다 : if 안에 들어가면 session 이 null이라면(세션이 시간경과로 null이 되면) 보내지 못하고 갈데가 없어짐 - 빈화면 도출
		response.sendRedirect(url);
	}

}
