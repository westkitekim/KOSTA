package org.kosta.webstudy16.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.webstudy16.model.ProductDAO;
import org.kosta.webstudy16.model.ProductVO;

/**
 * Servlet implementation class FindProductByIdServlet
 */
@WebServlet("/FindProductByIdServlet")
public class FindProductByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("productId");
		try {
			//ProductDAO는 Singleton Design Pattern이 적용되어 있으므로 new 로 생성하지 않고
			//static method로 객체의 주소값을 반환받아 사용한다
			ProductVO vo = ProductDAO.getInstance().findProductById(id);
			String path = null;
			if(vo == null) {
				path = "find-fail.jsp";
			}else {
				request.setAttribute("pvo", vo);
				path = "find-ok.jsp";
			}
			request.getRequestDispatcher(path).forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}













