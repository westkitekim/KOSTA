package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MockDAO;

/**
 * Servlet implementation class RedirectTestServlet
 */
@WebServlet("/RedirectTestServlet")
public class RedirectTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Model 연동
		MockDAO dao = new MockDAO();
		dao.register("상품정보");
		//redirect 방식은 응답시에 클라이언트에게 이동할 url 을 지정해서 클라이언트가 view로 요청하게 하는 방식으로
		//기존 request와 response는 유지되지 않는다
		//따라서 아래 코드와 같이 정보를 공유할 수 없다
		request.setAttribute("shareInfo", "검색정보");
		//redirect 방식으로 이동(컨트롤러에서 뷰로 이동)
		
		//forward는 재동작했을 때 콘솔창에 계속 출력된다(register())
		//서블릿이 등록되면 서버 다시 시작 (프로젝트)
		//insert, delete, update와 같이 데이터의 상태정보가 달라질 때는 redirect를 사용한다(한 번만 수행)
		//redirect는 이동한 파일명이 url 상에 그대로 출력된다(jsp로 변경), forward는 서블릿 파일 그대로, 새로고침하면 처음부터 재시작
		//redirect는 forward()시에 response - 클라에게 응답을 하는데 이동할 위치를 재지정한다
		//응답해서 브라우저에게 이동할 위치 알려줌 그 정보로 클라가 다시 요청 
		response.sendRedirect("redirect-result.jsp");
		
	}

}
