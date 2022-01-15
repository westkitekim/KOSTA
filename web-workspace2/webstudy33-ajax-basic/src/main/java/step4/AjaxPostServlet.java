package step4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AjaxPostServlet
 */
@WebServlet("/AjaxPostServlet")
public class AjaxPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//post방식 한글처리
		//Ajax 방식은 필요한 데이터만 응답하므로 웹페이지 정보없이 데이터만 출력한다
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		String message = request.getParameter("message");
		out.print(message + " db에 insert");
		//server상에 도달이 잘 되었는지 console에서 확인
		System.out.println(message);
		out.close();
		
		
		
	}

}
