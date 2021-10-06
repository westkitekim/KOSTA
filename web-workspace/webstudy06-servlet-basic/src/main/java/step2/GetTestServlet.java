package step2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetTestServlet
 */
public class GetTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//응답방식에 대한 인코딩 방식
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//클라이언트가 전송한 데이터를 입력받는다 
		String info = request.getParameter("food");//url에 작성되는 것 
		String info2 = request.getParameter("count");//int형으로 변환하려면 Integer.parseInt
		
		out.println("<h3>GetTestServlet doGet 메서드 실행</h3>");
		out.println("client가 보낸 메뉴 정보:" + info + " " + info2 + "인분");
		out.close();
	}

}



















