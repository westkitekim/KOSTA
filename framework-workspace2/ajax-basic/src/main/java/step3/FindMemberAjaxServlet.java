package step3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FindMemberAjaxServlet
 */
@WebServlet("/FindMemberAjaxServlet")
public class FindMemberAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 서버의 작업처리 시간이 많이 소요된다고 가정
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("userId");
		if (id != null && id.contentEquals("java")) {
			out.println("이름:아이유, 주소:판교");
		} else {
			out.println(id + " 아이디에 대한 회원정보가 없습니다");
		}
		out.close();
	}

}
