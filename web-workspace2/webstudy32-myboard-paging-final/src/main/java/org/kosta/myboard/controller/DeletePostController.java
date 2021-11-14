package org.kosta.myboard.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.myboard.model.BoardDAO;

public class DeletePostController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//로그인 체크
		/*
		 * HttpSession session = request.getSession(false); if (session == null ||
		 * session.getAttribute("mvo") == null) { //인증정보가 없으면 처음화면으로? return
		 * "redirect:ListController.do"; }
		 */
		
		//요청방식 post 체크
		if(!request.getMethod().equals("POST"))
			throw new ServletException("게시글 삭제는 POST 방식만 허용됩니다");
		
		String no = request.getParameter("no");
		BoardDAO.getInstance().deletePostByNo(no);
		return "redirect:ListController.do";
		
	}

}
