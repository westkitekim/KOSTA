package step1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SynServlet
 */
@WebServlet("/SynServlet")
public class SynServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;    
	/**
	 * 동기적 방식 통신의 예  step1-syn.jsp와 연동 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 서버의 작업처리 시간이 많이 소요된다고 가정 
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>동기적 방식</title>");
		out.println("</head>");
		out.println("<body bgcolor=yellow>");
		out.println("SynServlet이 응답했습니다");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}

























