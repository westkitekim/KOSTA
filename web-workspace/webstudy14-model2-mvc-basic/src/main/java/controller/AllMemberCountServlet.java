package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;

/**
 * Servlet implementation class AllMemberCountServlet
 */
@WebServlet("/AllMemberCountServlet")
public class AllMemberCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(getServletName() + " 컨트롤러 실행 ");
		try {
			//Model 과 연동
			MemberDAO dao = new MemberDAO();
			int count = dao.getTotalCount();
			//Model 과의 연동 결과를
			//request 객체에 정보를 할당(공유)해서 View 가 사용할 수 있도록 한다 -> response가 끝날 때까지 저장
			//forward인 상태로 set했기 때문에 allmembercount.jsp에서 getAttribute()가능
			request.setAttribute("count", count);//session에서도 사용한 setAttribute()
			//forward 방식으로 View 로 이동하게 한다 (클라는 모르고 서버상에서만 이동된다 - forward로 이동되어도 url은 servletname 그대로)
			//getReuquest이동경로 작성
			//화면에 대한 것은 allmembercount.jsp에 일임한다. forward 방식은 request 요청방식 유지하며 전송
			//getRequestDispatcher()메서드를 통해 RequestDispatcher 객체를 생성하여 forward()메서드 사용(팩토리 메서드)
			//getRequestDispatcher()의 인자값에는 이동할 url 작성(하지만 웹 페이지상에서는 처음 url 경로 유지)
			request.getRequestDispatcher("allmembercount.jsp").forward(request, response);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
