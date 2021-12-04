package step2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;

import model.CarDAO;
import model.CarDTO;

/**
 * 
 * Servlet implementation class FindCarXMLServlet
 */
@WebServlet("/FindCarXMLServlet")
public class FindCarXMLServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/xml;charset=utf-8");
		PrintWriter out=response.getWriter();
		String maker=request.getParameter("maker");
		CarDTO car=CarDAO.getInstance().getCarInfo(maker);
		
		Document myDocument=new Document();
		Element root=new Element("car");
		myDocument.setRootElement(root);
		root.addContent(new Element("model").addContent(car.getModel()));
		root.addContent(new Element("price").addContent(car.getPrice()+""));
		
		//응답할 xml을 생성 
		XMLOutputter xmlOut=new XMLOutputter();
		out.print(xmlOut.outputString(myDocument));
		out.close();
	}
}
















