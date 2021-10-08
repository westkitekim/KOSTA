package step1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycleServlet
 */
public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LifeCycleServlet() {
        super();
        System.out.println("LifeCycleServlet 객체 생성");
    }
    
    @Override
    	public void init() throws ServletException {
    		//매개변수 없어야함
    		System.out.println("init() 실행");
    	}
	/*
	 	내부구조 확인: Apache tomcat 라이브러리 - jsp api, servlet api... -> 어떤 웹서버든 was든 가지고 있는 library
		apache tomcat은 catalina.jar에 구현되어있음 ex. 오라클 설치하면 ojdbc6.jar과 비슷 
		requestfacade
		implements 하는 
		WAS를 바꾸더라도 인터페이스 서블릿 표준을 지키기 때문에 상관없음
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		//System.out.println(request.getClass());//어떤클래스로 만들어졌는지 확인 - 콘솔창에서 확인 class ort.apache.catalina.connector.RequestFacade
		System.out.println("service() 실행");//요청시마다 실행 
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();//소켓에서 new printWriter와 같은 역할
		out.println("<h3>LifeCycleServlet service 계열 메서드 doGet method 실행</h3>");
		
		out.close();
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy() 실행");//서버탭에서 stop 할 때만 1번 실행
	}
}
