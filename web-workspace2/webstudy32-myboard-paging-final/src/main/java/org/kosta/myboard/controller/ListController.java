package org.kosta.myboard.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.myboard.model.BoardDAO;

public class ListController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("list", BoardDAO.getInstance().getPostingList());
		//template layout 페이지를 이용해 리스트 화면을 제공 
		request.setAttribute("url", "board/list.jsp");
		return "layout.jsp";
	}
}
