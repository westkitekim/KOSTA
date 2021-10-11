package step1;

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
 * Servlet implementation class SetCookieServlet
 */
@WebServlet("/SetCookieServlet")
public class SetCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//기본생성자는 default이므로 편의상 삭제
	//webcontainer 또는 ServletContainer 또는 Container가(다 같은 것) 신속하고 빠르게 서버에 접근 --> http프로토콜 기반 서비스를 효율적으로 만들 수 있다
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
		String name = getServletName();//= getServletConfig().getServletName();
		out.println("<h3>" + name + "</h3>");
		//시간 정보 공백 빼기 
		//쿠키 값에 유효하지 않은 문자 예외? -- 최소단위로 단위테스트 -- TDD 
		//쿠키는 공란을 허용하지 않기 때문에 replace로 대체한다 
		String time = new Date().toString().replace(" ", "-");
		//쿠키 생성 body 안에
		//★쿠키는 문자열 기반이며 공백을 허용하지 않는다★
		//java.util.Date, Date()형은 안되기 때문에 toString()으로 형변환
		Cookie cookie = new Cookie("time",time);
		//쿠키 유효시간을 설정 ( 만약 설정하지 않고 브라우저를 끄면 쿠키도 사라진다 ) 
		//시간 설정하고 GetCookieServet에 가서 확인하면 client시간이 해당 시간동안 유지된다.
		cookie.setMaxAge(60);//60초 동안 유지
		
		//쿠키를 클라이언트 측으로 전송, output 될 때 쿠키도 전송
		response.addCookie(cookie);
		out.println("cookie를 클라이언트 측으로 전달<br><br>");
		out.println("cookie에 저장한 time 정보:" + time);
		out.println("<br><br><a href=GetCookieServlet>GetServlet에서 저장한 time cookie 정보확인</a>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}


































