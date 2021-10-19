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
 * 
 * step6에서는 컨트롤러명.do 스타일로 요청을 처리
 * 웹어노테이션 url-pattern 설정을 *.do로 설정(여러 개를 처리하기 위함)
 */
@WebServlet("*.do")
public class FrontControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doDispatch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//컨트롤러명 추출 1> (이전코드)
			//String command = request.getParameter("command");
			
			//컨트롤러명 추출 2> 
			//요청 uri 를 통해 컨트롤러명을 추출 (command)
			String uri = request.getRequestURI();
			String contextPath = request.getContextPath();
			String command = uri.substring(contextPath.length() + 1, uri.length() - 3);
			
			//HandlerMapping 객체 이용 방법(계층구조 형성-다형성)
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
