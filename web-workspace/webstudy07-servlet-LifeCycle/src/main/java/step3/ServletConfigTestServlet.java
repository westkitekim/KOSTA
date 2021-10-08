package step3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletConfigTestServlet
 */
public class ServletConfigTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();//소켓에서 new printWriter와 같은 역할
		out.println("<h3>ServletConfig study</h3>");
		String name = this.getServletConfig().getServletName();
		out.println("ServletConfig로부터 Servlet Name을 반환받음:" + name);
		String frameworkConfig=getServletConfig().getInitParameter("contextConfigLocation");//매개변수 contextConfigLocation : container의 설정파일 위치를 말함
		out.println("<hr>framework 설정파일:" + frameworkConfig);
		out.close();
		//getInitParmeter : <init-param> 
		//왜 굳이 분리? : 실지ㅔ로 나중에 서블릿은 프레임워크 가면 직접 코딩하지 않음
					  //아주 잘 만든 프레임웤이 있기 때문에 우리와 맞게 커스터마이징하여 사용
		//			   잘 만든 섭ㄹ릿을 우리 현지에 맞게 설정을 잡아서 쓰는 것 - doGEt 등 서블릿 은 만들어져 있음 
		//			   잘ㅁ 만든 서블릿에서 받아서 로드하게 되어있음 -- 코드와 설정이 분리 
		// 		       잚 만들어진 프레임워크를 이용하기 위해 설정파일 분리해서 사용한다 
	}

}
