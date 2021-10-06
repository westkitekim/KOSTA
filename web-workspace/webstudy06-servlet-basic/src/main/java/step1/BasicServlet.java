package step1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * 모든 서블릿과 jsp는 일반적으로 HttpServlet을 상속받는다 
 */
public class BasicServlet extends HttpServlet{
	//객체직렬화시 serialversionID
	//HttpServlet : 모든 서블릿과 JSP의 부모 
	private static final long serialVersionUID = 5321989723167363912L;
	/*
	 * doGet() method : client 측에서 get 방식 요청시에 실행되는 메서드
	 * HttpServletRequest : client의 요청 정보를 저장하는 객체의 인터페이스 타입(인터페이스)
	 * HttpServletResponse : client에게 응답하기 위한 정보(인터페이스)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet : GET과 POST의 요청방식 중 GET방식
		//web은 일반적으로 text 방식, 컨텐츠의 타입 지정(서버측)
		response.setContentType("text/html;charset=utf-8");//응답시 한글처리를 위해 charset utf-8을 지정한다
		//													 charset="utf-8"해야 한글반영
		PrintWriter out = response.getWriter();//소켓에서 new printWriter와 같은 역할
		out.println("<h3>BasicServlet doGet method 실행</h3>");//404 BasicServlet 설정정보 없기 때문
		
		out.close();//쓰고 나면 닫아주기
	}
	
	/*
	 * doPost() method : client 측에서 post 방식 요청시에 실행되는 메서드
	 * 
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();//
		out.println("<h3>BasicServlet doPost method 실행</h3>");
		out.close();
	}
}














