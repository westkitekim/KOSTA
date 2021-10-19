package org.kosta.webstudy23.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.webstudy23.model.ProductDAO;
import org.kosta.webstudy23.model.ProductVO;

public class AllProductListController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<ProductVO> list = ProductDAO.getInstance().getAllProductList();
		request.setAttribute("productList", list);
		return "product-list.jsp";//forward
	}

}
