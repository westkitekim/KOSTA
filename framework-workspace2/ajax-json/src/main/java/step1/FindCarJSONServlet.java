package step1;

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
 * Servlet implementation class FindCarJSONServlet
 */
@WebServlet("/FindCarJSONServlet")
public class FindCarJSONServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 *  JSON 방식으로 Ajax 응답하는 예제 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		String maker=request.getParameter("maker");
		CarDTO car=CarDAO.getInstance().getCarInfo(maker);
		JSONObject json=new JSONObject(car);
		out.print(json.toString());
		out.close();
	}
}























