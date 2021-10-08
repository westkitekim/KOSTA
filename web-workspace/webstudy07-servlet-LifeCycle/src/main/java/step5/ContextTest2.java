package step5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContextTest2
 */
public class ContextTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContextTest2() {
        super();
        // TODO Auto-generated constructor stub
    }
    //실제 웹컨테이너가 아래 메서드 호출 - 권장사항 X
    //즉 ServletConfig를 할당받지 못했으므로 ServletContext를 사용할 수 없다는 것을 확인해보는 코드 
    @Override
    public void init(ServletConfig config) throws ServletException {
    	System.out.println("test를 위해 ServletConfig 를 할당받는 init을 오버라이드한다 " + config.getServletContext());
    	//ServletConfig를 할당받아 초기화하는 작업을 고의로 생략해본다(권장사항 아님), 부모 생성자 생략 super()
    	//다시 할당받는 코드를 명시해본다 -> ServletConfig 없이는 ServletContext에 접근할 수 없다. 
    	super.init(config);
    	//아래 getServeltConfig()에서 nullpointer 예외
    	//이렇게 되면 Servlet
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//String name = getServletConfig().getServletName();
		//out.println("<h3>" + name + "에서 ServletContext를 테스트</h3>");
		String info = getServletConfig().getServletContext().getInitParameter("security");
		out.println("ServletContext로부터 정보를 가져옴:" + info);
		out.close();
	}

}
