package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 	@WebServlet("*.do") 로 변경해
 * 	.do 로 요청되는 모든 클라이언트의 요청을 처리
 */
@WebServlet("*.do")
public class FrontControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//index 에서 실행좀 해.. 서블릿에서 왜 실행하니..
		System.out.println(request.getRequestURI());
		System.out.println(request.getContextPath());
		//contextPath와 .do 를 제외한 컨트롤명만 추출 
		String uri = request.getRequestURI();//	/webstudy22-front-do-unit-test/FindController.do
		String contextPath = request.getContextPath();//	/webstudy22-front-do-unit-test
		System.out.println(uri.substring(contextPath.length() + 1, uri.length() - 3));// FindController
	
	}



}
