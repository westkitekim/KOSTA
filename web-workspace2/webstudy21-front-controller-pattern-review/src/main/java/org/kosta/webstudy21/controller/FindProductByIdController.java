package org.kosta.webstudy21.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.webstudy21.model.MockDAO;

public class FindProductByIdController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("productId");
		String path = null;
		String productInfo = MockDAO.getInstance().findProductById(id);
		if(productInfo == null) {
			path = "find-fail.jsp";
		}else {
			path = "find-ok.jsp";
			request.setAttribute("productInfo", productInfo);
		}
		return path;
	}

}
