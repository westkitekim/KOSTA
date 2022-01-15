package step3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AjaxMemberServlet
 */
@WebServlet("/AjaxMemberServlet")
public class AjaxMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Ajax 방식은 필요한 데이터만 응답하므로 웹페이지 정보없이 데이터만 출력한다
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		String memberId = request.getParameter("memberId");
		out.print(memberId + "에 대한 회원정보... ajax server의 db에서 조회한 정보  ");
		System.out.println(memberId + " 회원아이디에 대한 조회 정보 ajax 방식으로 요청받아 필요한 데이터만 응답함");
		out.close();
		
		
	
	}

}
















