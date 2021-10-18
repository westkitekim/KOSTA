package org.kosta.webstudy21.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontControllerServlet
 */
@WebServlet("/FrontControllerServlet")
public class FrontControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/*
	 * client가 전송한 command를 받아온다 ( 이 command를 이용해 요청을 처리할 Controller 객체를 생성하게 된다 )
	 * HandlerMapping ( 컨트롤러 객체 생성을 전담하는 객체 ) 를 이용해 Controller 객체를 리턴받는다
	 * Controller 객체를 실행한다 ( Controller interface의 abstract method 인 execute() 실행 )
	 * 실행 후 반환받는 view path 를 이용해 forward 방식 또는 redirect 방식으로 클라이언트에게 응답한다
	 */
	protected void doDistpatch(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String command = request.getParameter("command");//어떤 서비스인지 구분(hidden의 value)
			//객체생성 Factory
			Controller controller = HandlerMapping.getInstance().create(command);
			String path = controller.execute(request, response);//view path 반환 
			if(path.startsWith("redirect:"))
				response.sendRedirect(path.substring(9));
			else 
				request.getRequestDispatcher(path).forward(request, response);
				
		} catch(MethodNotAllowedException me) {
			me.printStackTrace();
			response.sendRedirect("method-error.jsp");
		} catch(Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doDistpatch(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//http request body 의 데이터를 인코딩 : 한글처리
		request.setCharacterEncoding("utf-8");
		doDistpatch(request, response);
	}

}
