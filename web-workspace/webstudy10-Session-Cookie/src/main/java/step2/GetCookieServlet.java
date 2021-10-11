package step2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetCookieServlet
 */
@WebServlet("/GetCookieServlet")
public class GetCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// 서블릿에서 뷰를 만든다면 다 해줘야함
		out.println("<!DOCTYPE HTML>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>home</title>");
		out.println("</head>");
		out.println("<body>");
		String name = getServletName();// = getServletConfig().getServletName();
		out.println("<h3>" + name + "</h3>");
		//client request로부터 cookie 정보를 받아온다
		//쿠키를 저장한 게 없으므로 null이 출력된다 
		//System.out.println(request.getCookies());//web application에서 저장한 쿠키가 하나 이상 존재하지 않으면 null이 반환
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {//쿠키의 존재 유무 확인
			//cookies 배열을 for loop 이용해 반복하면서 cookie의 name이 time 인 cookie의 value를 화면에 제공
			//cookie 의 getName(), getValue() 메서드를 이용 
			boolean flag = false;
			for(int i = 0; i < cookies.length; i++) {
				if(cookies[i].getName().equals("time")) {
					out.println("client로부터 받아온 time cookie value" + cookies[i].getValue());
					flag = true;
					break;
				}
			}
			//시스템상 다른 쿠키가 존재할 수 있기 때문에 
			//time 쿠키의 존재 유무를 판단하기 위한 코드
			if(flag = false)
				out.println("time 쿠키가 존재하지 않습니다");
			
		}else {
			out.println("쿠키가 존재하지 않습니다");
			
		}
		
		out.println("<br><br><a href=SetCookieServlet>SetCookieServlet으로 이동</a>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}











































