package org.kosta.myboard.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WritePostFormController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//로그인 체크
		/*
		 * HttpSession session = request.getSession(false); if (session == null ||
		 * session.getAttribute("mvo") == null) { //인증정보가 없으면 처음화면으로? return
		 * "redirect:ListController.do"; }
		 */
		
		/*
			 * else { String title = request.getParameter("title"); String content =
			 * request.getParameter("content"); MemberVO vo = (MemberVO)
			 * session.getAttribute("mvo"); BoardDAO.getInstance().posting(title, content,
			 * vo.getId()); return "write.jsp"; }
			 */
		request.setAttribute("url", "board/write.jsp");
		return "layout.jsp";
	}
}































