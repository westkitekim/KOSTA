package step5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import model.CarDAO;
import model.CarDTO;

/**
 * Servlet implementation class JSONObjectServlet
 */
@WebServlet("/JSONObjectServlet")
public class JSONObjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Ajax 방식은 필요한 데이터만 응답하므로 웹페이지 정보없이 데이터만 출력한다
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		String maker = request.getParameter("maker");
		CarDTO car = CarDAO.getInstance().getCarInfo(maker);
		JSONObject json = new JSONObject(car);
		out.print(json.toString());
		out.close();
	
	}

}
