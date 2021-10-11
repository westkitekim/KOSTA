package step5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberVO;

/**
 * Servlet implementation class SessionThreeServlet
 */
@WebServlet("/SessionThreeServlet")
public class SessionThreeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//서블릿에서 뷰를 만든다면 아래와 같이 html코드 다 작성해야함
		out.println("<!DOCTYPE HTML>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>home</title>");
		out.println("</head>");
		out.println("<body>");
		String name = getServletName();//getServletConfig().getServletName();과 같다
		out.println("<h3>" + name + "</h3>");
		//request.getSession(false) : 기존 세션이 존재하면 기존 세션 반환, 기존 세션이 존재하지 않으면 null을 반환
		HttpSession session = request.getSession(false);
		if(session != null) {//세션이 존재하면 세션을 무효화 시킨다 ( session.invalidate() : 로그아웃시 사용하는 기능 )
			session.invalidate();
			out.println("세션을 무효화시킴(session invalidate 처리)");
		}else {
			out.println("세션이 존재하지 않습니다");
		}
		
		out.println("<br><br><a href=SessionOneServlet>SessionOneServlet으로 이동</a>");
		out.println("<br><br><a href=SessionTwoServlet>SessionTwoServlet으로 이동</a>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}


































