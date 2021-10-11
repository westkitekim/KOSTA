package org.kosta.webstudy18.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.webstudy18.model.MemberDAO;
import org.kosta.webstudy18.model.MemberVO;

/**
 * Servlet implementation class RegisterMemberServlet
 */
@WebServlet("/RegisterMemberServlet")
public class RegisterMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doPost 한글처리
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		//나중에 프레임웍 사용하는 것을 대비하여 객체 만들어서 넘기는 방법으로 연습한다
		MemberVO vo = new MemberVO(id, password, name, address);
		try {
			MemberDAO.getInstance().register(vo);
			//재동작되면 안되기 때문에 redirect
			response.sendRedirect("register-result.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
