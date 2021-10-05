package step1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    /**
     * Servlet 맛보기
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request : socket.getinputstream, response
		response.setContentType("text/html;charset=utf-8");//저장하면 컴파일이 되는데 was에 컴파일된 파일이 로드됨
		PrintWriter out=response.getWriter();
		//servlet은 이 용도가 아니지만(html 개별 작성) 처음이기 때문에 연습용도로 작성
		out.println("<html>");
		out.println("<body>");
		out.println("<h3>Hello Servlet</h3>");
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}

}



























