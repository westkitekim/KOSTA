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
 * Servlet implementation class RegisterProductServlet
 */
@WebServlet("/RegisterProductServlet")
public class RegisterProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * 제품 등록의 경우 클라이언트가 재요청시에(=새로고침, refresh) 이전에 등록했던 데이터가
	 * 중복되어 등록되면 안 되기 때문에 redirect를 이용하여 한번 등록이 되었으면 
	 * 다른 페이지를 보여주게 한다.(로그인도 마찬가지) 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// post 방식은 http request body에 데이터가 전달되므로 별도의 한글 처리가 필요하다
		request.setCharacterEncoding("utf-8");
		// client가 전송한 상품 정보를 받아온다
		String name = request.getParameter("name");
		String maker = request.getParameter("maker");
		int price = Integer.parseInt(request.getParameter("price"));

		try {
			// productDAO는 Singleton Design Pattern 이 적용되어 있으므로
			// new 생성자로 객체 생성하는 것이 아니라 static 메서드로 객체의 주소값을 리턴받아
			// register메서드를 실행한다
			ProductDAO.getInstance().register(new ProductVO(name, maker, price));
			//forward 이동방식은 결과화면에서 사용자가 새로고침을 할 경우 재등록 되므로 
			//redirect 이동방식으로 응답시 클라이언트에게 지정한 url로 이동하도록 처리한다
			response.sendRedirect("register-result.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}









