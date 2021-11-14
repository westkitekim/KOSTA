package org.kosta.myboard.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(request.getMethod().equals("POST") == false) {
			throw new ServletException("로그아웃은 post 방식만 가능합니다");
		}
		//기존 세션이 있으면 기존세션 반환, 없으면 null 반환
		HttpSession session = request.getSession(false);
		if(session != null)
			session.invalidate();
		return "redirect:ListController.do";
	}

}
