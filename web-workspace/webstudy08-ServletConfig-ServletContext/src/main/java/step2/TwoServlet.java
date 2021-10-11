package step2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TwoServlet
 */
public class TwoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TwoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * ServletContext로부터 OneServlet이 할당한 정보를 얻어와(get) 보는 예제
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		ServletConfig config = getServletConfig();//init()에서 할당받았으므로 ServletConfig 사용 가능 
		//ServletConfig로부터 현 서블릿의 이름을 받아온다 
		out.println("<h3>" + config.getServletName() + "</h3>");
		//ServletContext에 OneServlet이 할당한 정보를 getting
		//ServletContext 는 모든것을 담기 위해 Object로 담겨져있기 때문에 String으로 downcasting 필요 - Object Casting
		String info = (String) config.getServletContext().getAttribute("notice");
		out.println("<h4>ServletContext로부터 OneServlet이 할당한 정보를 확인:");
		out.println(info + "</h4>");
		out.println("<a href=OneServlet>OneServlet에서 확인</a>");
		out.println("<hr>");
		//어떤 서블릿이든 접근 가능 : ServletContext
		out.println("ServletContext의 초기 파라미터:" + config.getServletContext().getInitParameter("appSecurity"));
		out.close();
	}

}



















