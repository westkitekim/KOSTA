package step4;

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
 * Servlet implementation class SessionTwoServlet
 */
@WebServlet("/SessionTwoServlet")
public class SessionTwoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//코드 수정하다 계속 리로딩 하면 nullpointerException,나오므로 기다리기 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//서블릿에서 뷰를 만든다면 다 해줘야함
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
		if(session != null) {
			out.println("session id:" + session.getId() + "<br>");
			//회원 객체를 세션으로부터 리턴받아 회원의 name을 출력해본다
			//session의 getAttribute(name) 을 이용// 
			MemberVO mvo = (MemberVO)session.getAttribute("mvo");
			out.println("회원이름:" + mvo.getName());
		}else {
			out.println("세션이 존재하지 않습니다");
		}
		
		out.println("<br><br><a href=SessionOneServlet>SessionOneServlet으로 이동</a>");
		out.println("<br><br><a href=SessionThreeServlet>SessionThreeServlet으로 이동</a>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
       
}















