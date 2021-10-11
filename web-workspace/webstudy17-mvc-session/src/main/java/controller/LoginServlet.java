package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberVO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * client가 전송한 아이디와 패스워드를 전달받아 java, abcd 인지 확인해서 
		 * 일치하면 
		 * 1. 세션에 MemberVO 인증객체를 할당하고 
		 * 2. login-ok.jsp로 redirect
		 * 
		 * 일치하지 않으면 
		 * 1. login-fail.jsp로 redirect 한다
		 * 
		 */
		//request.setCharacterEncoding("utf-8");
		String id = request.getParameter("memberId");
		String password = request.getParameter("memberPass");
		String url = null;
		if(id.equals("java")&&password.equals("abcd")) {
			HttpSession session = request.getSession();//jsp에서는 필요없는 코드
			session.setAttribute("mvo", new MemberVO(id, null, "아이유", null));
			url = "login-ok.jsp";
		}else {
			url = "login-fail.jsp";
		}
		response.sendRedirect(url);
	}

}
















