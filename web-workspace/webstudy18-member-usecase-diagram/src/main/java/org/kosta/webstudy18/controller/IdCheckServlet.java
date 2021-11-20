package org.kosta.webstudy18.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.webstudy18.model.MemberDAO;

/**
 * Servlet implementation class IdCheckServlet
 */
@WebServlet("/IdCheckServlet")
public class IdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String url = null;
		
		try {
			boolean flag = MemberDAO.getInstance().idCheck(id);
			if(flag == true) {
				url = "idcheck-fail.jsp";
			} else {
				url = "idcheck-ok.jsp";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	*/
	
	//강사님 풀이
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		
		try {
			boolean result = MemberDAO.getInstance().idCheck(id);
			String path = null;
			//아이디가 존재하면 사용할 수 없으므로 idcheck-fail로 이동
			if(result) {//if(result == true)
				path = "idcheck-fail.jsp";
			}else {
				String a = "a,b,c";
				path = "idcheck-ok.jsp";
			}
			request.getRequestDispatcher(path).forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	

}
