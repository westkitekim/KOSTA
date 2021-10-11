package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MockDAO;

/**
 * Servlet implementation class ForwardTestServlet
 */
@WebServlet("/ForwardTestServlet")
public class ForwardTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Model과 연동
		MockDAO dao = new MockDAO();
		dao.register("상품정보");
		//forward 방식으로 이동
		//forward 방식으로 하면 콘솔창에 메세지 계속 출력된다 - 상품정보 등록작업일 경우 계속 등록되면 안되므로 redirect방법으로 구현해야 한다 
		String path = "forward-result.jsp";
		//forward 방식은 기존 request와 response 가 유지된 상태로 이동되며
		//아래와 같이 request에 정보를 할당할 수 있다(출력되는 것 확인)
		request.setAttribute("shareInfo", "검색정보");
		request.getRequestDispatcher(path).forward(request, response);
	}

}
