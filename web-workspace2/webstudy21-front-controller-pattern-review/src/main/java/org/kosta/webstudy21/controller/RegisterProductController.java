package org.kosta.webstudy21.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.webstudy21.model.MockDAO;

public class RegisterProductController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//어떤 방식으로 접근하는지 확인 가능
		//System.out.println("request method:" + request.getMethod());//method 요청방식 확인(링크는 GET)
		
		//post방식만 허용하고 싶을 경우 예외처리 구현
		//post방식이 아니면 예외발생(spring에서는 MethodNotAllowedException)
		if(!request.getMethod().equals("POST"))
			//throw new ServletException("POST 방식만 허용됩니다");//FrontControllerServlet으로 가서 catch구문에서 error.jsp 페이지 실행
			throw new MethodNotAllowedException();//예외발생시 바로 throw 되어 아래코드 수행X
		String productInfo = request.getParameter("productInfo");
		MockDAO.getInstance().registerProduct(productInfo);
		return "redirect:register-result.jsp";
	}

}
