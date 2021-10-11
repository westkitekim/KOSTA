package step2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycleServlet
 */
//어노테이션 기반 서블릿 설정 ( xml 기반 서블릿 설정 webstudy07의 step1 에 있다 )

//웹 어플리케이션 실행시점에 미리 해당 서블릿을 초기화 하도록 web.xml 의 load-on-startup 태그 설정을 
//어노테이션 방식으로 설정해본다
@WebServlet(urlPatterns = "/LifeCycleServlet", loadOnStartup = 1)
public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * 서블릿 객체 생성은 1번만 된다
     */
    public LifeCycleServlet() {
        super();
        System.out.println("LifeCycleServlet 객체 생성");
    }
    
    /**
     * 매개변수 없는 init()을 권장
     * init은 서블릿당 1번 실행
     * 
     * @Override : 컴파일시에 오버라이드 문법 검사 
     * 자바 어노테이션 : 컴파일 및 런타임 시점에 시스템에 영향을 주는 의미있는 주석 
     */
    @Override
    public void init() throws ServletException {
    	System.out.println("init() 실행");
    }

	/**
	 * service()는 클라이언트 호출시 매번 실행 - doGet()도 서비스 계열
	 * HttpServlet을 상속받았기 때문에 service()메서드에서 doGet()을 호출해준다 
	 * 
	 * web container가 service 메서드를 호출
	 * 상속받은 HttpServlet의 service 메서드가 
	 * 클라이언트의 요청 방식에 따라 doGet() or doPost() 를 실행 
	 * 
	 * -> Template Method Design Pattern 형식이다 
	 * method 별로 doGet(), doPost() 분기한다
	 * 
	 * service()와 doGet(), doPost() 같게 생각하면 된다 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("Annotation 설정 기반 서블릿 테스트 " + getServletConfig().getServletName());
		System.out.println("service() -> doGet() 실행");
		out.close();
	}
	
	/**
	 * destroy는 서비스 종료 직전 ( WAS 종료 직전 ) 에 한 번 호출
	 */
	@Override
	public void destroy() {
		System.out.println("destroy() 실행");
	}
}















