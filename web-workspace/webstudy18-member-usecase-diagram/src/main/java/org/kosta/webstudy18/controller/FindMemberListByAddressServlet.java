package org.kosta.webstudy18.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.kosta.webstudy18.model.MemberDAO;
import org.kosta.webstudy18.model.MemberVO;

/**
 * Servlet implementation class FindMemberListByAddressServlet
 */
@WebServlet("/FindMemberListByAddressServlet")
public class FindMemberListByAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//forward로 이미 확정되어있음
		String address = request.getParameter("address");
		String path = null;
		try {
			ArrayList<MemberVO> list = MemberDAO.getInstance().findMemberListByAddress(address);
			
			if(list != null) {
				request.setAttribute("mvoAddr", list);
				path = "findbyaddress-result.jsp";
			}else {
				path = "index.jsp";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher(path).forward(request, response);
		//response.sendRedirect(url); redirect 아니다
		
	}
	*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//forward로 이미 확정되어있음
		String address = request.getParameter("address");
		try {//??????????
			ArrayList<MemberVO> list = MemberDAO.getInstance().findMemberListByAddress(address);
			request.setAttribute("list", list);
			request.getRequestDispatcher("findbyaddress-result.jsp").forward(request, response);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//response.sendRedirect(url); redirect 아니다
		
	}

}
