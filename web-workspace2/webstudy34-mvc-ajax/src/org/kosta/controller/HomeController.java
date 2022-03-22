package org.kosta.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.model.MemberDAO;

public class HomeController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int count=MemberDAO.getInstance().getMemberTotalCount();
		request.setAttribute("totalCount", count);		
		request.setAttribute("url", "/home.jsp");
		return "layout.jsp";
	}
}











