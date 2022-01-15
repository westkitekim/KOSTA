package step2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AsynServlet
 */
@WebServlet("/AsynServlet")
public class AsynServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	int count = 1;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 서버의 작업처리 시간이 많이 소요된다고 가정 
		/*
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		//Ajax 방식은 필요한 데이터만 응답하므로 웹페이지 정보없이 데이터만 출력한다
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.print("ajax 응답 " + count);
		System.out.println("ajax 방식으로 요청받아 필요한 데이터만 응답함" + count++);
		out.close();
	}
}














