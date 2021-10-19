package org.kosta.webstudy20.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * FrontControllerServlet이 사장님이라 생각
 * 자동화??! 
 * step4 : 개별 컨트롤러 객체 생성로직도 분리하는 작업 
 */
@WebServlet("/FrontControllerServlet")
public class FrontControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doDispatch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String command = request.getParameter("command");
			//HandlerMapping 객체 이용 방법
			Controller controller = HandlerMapping.getInstance().create(command);
			String path = controller.execute(request, response);
			if(path.startsWith("redirect:"))//redirect: 으로 시작되는 path인 경우
				response.sendRedirect(path.substring(9));
			else
				request.getRequestDispatcher(path).forward(request, response);
		} catch(Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doDispatch(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//http request body에 별도의 한글처리
		doDispatch(request, response);
	}

}
