package step2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

/**
 * Servlet implementation class JSONArrayServlet
 */
@WebServlet("/JSONArrayServlet")
public class JSONArrayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<String> list=new ArrayList<String>();
		list.add("손흥민");
		list.add("황의조");
		list.add("기성용");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		//JSONArray로 응답 
		JSONArray ja=new JSONArray(list);
		out.print(ja.toString());//view에 보냄
		out.close();
	}
}






















