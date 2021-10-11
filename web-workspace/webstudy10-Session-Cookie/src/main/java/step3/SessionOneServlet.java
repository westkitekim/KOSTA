package step3;

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
 * Servlet implementation class SessionOneServlet
 */
@WebServlet("/SessionOneServlet")
public class SessionOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
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
		//getSession() : 기존 세션이 있으면 기존 세션 반환, 없으면 새로 생성 (파라미터 없는 getSession() 메서드)
		HttpSession session = request.getSession();//이때 내부적으로 쿠키 생성, name : jsessionid, value : WAs에서 만들어준 session 객체와 연결되어있는 아이
		//브라우저마다 다른 클라이언트로 인식하기 때문에 같은 url을 넣어도 다른 브라우저라면 다른 Id가 생성됨 
		//웹 브라우저의 다른 탭이여도 같은 클라이언트로 인식 
		//세션 기간은 기본으로 30분이며 
		//어떤 클라이언트인지 확인 : getId()
		out.println("session id:" + session.getId() + "<br><br>");
		//세션에 MemberVO 객체를 할당한다
		session.setAttribute("mvo", new MemberVO("java", "1234", "아이유", "종로"));
		out.println("세션에 회원정보를 저장<br><br>");
		out.println("<a href=SessionTwoServlet>SessionTwoServlet으로 이동</a>");
		
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}





































