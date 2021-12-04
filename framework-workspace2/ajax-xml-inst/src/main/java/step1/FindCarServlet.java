package step1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CarDAO;
import model.CarDTO;

/**
 * Servlet implementation class FindCarServlet
 */
@WebServlet("/FindCarServlet")
public class FindCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		String maker=request.getParameter("maker");
		CarDTO car=CarDAO.getInstance().getCarInfo(maker);
		out.print(car.getModel()+" "+car.getPrice());
		out.close();
	}
}













