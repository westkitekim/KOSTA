package org.kosta.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("*.do")
public class FrontControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;    
    public FrontControllerServlet() {
        super();       
    }
    /*
     *  step0 예외 발생시 기록을 남기고 error.jsp로 redirect 처리한다 
     *  step1 클라이언트의 요청 uri 로부터 컨트롤러명을 추출 
     *  step2 HandlerMapping 을 이용해 해당 컨트롤러 객체를 반환 
     *  step3 반환받은 컨트롤러 객체를 실행 후 리턴값(path정보)을 반환 
     *  step4 응답할 path를 forward or rediect or Ajax방식으로 response 하게 한다 
     */
    public void doDispatch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
    	
    	String uri=request.getRequestURI();    	
    	String contextPath=request.getContextPath();    	
    	String command=uri.substring(contextPath.length()+1,uri.length()-".do".length());    
    	Controller controller=HandlerMapping.getInstance().create(command);
    	String path=controller.execute(request, response);
    	if(path.startsWith("redirect:")) {
    		response.sendRedirect(path.substring("redirect:".length()));
    		
    	}else if(path.equalsIgnoreCase("AjaxView")) {
    		//spring responsebody 참고(검색)
    		//ajax 응답은 필요한 데이터만 전송하므로 forward 또는 redirect 방식이 아니라 response를 이용해 직접 출력한다
    		response.setContentType("text/html;charset=utf-8");
    		PrintWriter out = response.getWriter();
    		out.print(request.getAttribute("responsebody").toString());
    		out.close();
    		
    	}else {
    		request.getRequestDispatcher(path).forward(request, response);
    	}
    	
    	}catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doDispatch(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doDispatch(request, response);
	}
}






