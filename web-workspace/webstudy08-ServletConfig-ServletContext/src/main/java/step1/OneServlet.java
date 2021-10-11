package step1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OneServlet
 */
public class OneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * ServletConfig와 ServletContext를 테스트하는 예제
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//init()에서 할당받았으므로 ServletConfig 사용 가능
		ServletConfig config = getServletConfig(); 
		//ServletConfig로부터 현 서블릿의 이름을 받아온다 
		out.println("<h3>" + config.getServletName() + "</h3>");
		//스프링 맛보기 
		//설정파일 편집은 아래와 같이 변수를 던져줌, xml만 수정하면 사용 
		String springConfig = config.getInitParameter("contextConfigLocation");
		out.println("<h4>" + springConfig + " 스프링 설정파일을 로딩</h4>");
		//웹어플리케이션 공유 자원인 ServletContext 객체에 접근하여 
		//특정 정보를 할당해본다
		ServletContext context = config.getServletContext();
		//setAttribute : map처럼 name value 로 할당
		//admin : OneServlet이 할당한 정보 value
		context.setAttribute("notice", "admin@kosta.or.kr");
		out.println("<a href=TwoServlet>TwoServlet에서 확인</a>");
		out.println("<hr>");
		//어떤 서블릿이든 접근 가능 : ServletContext
		out.println("ServletContext의 초기 파라미터:" + config.getServletContext().getInitParameter("appSecurity"));
		
		out.close();
		
	}
}














