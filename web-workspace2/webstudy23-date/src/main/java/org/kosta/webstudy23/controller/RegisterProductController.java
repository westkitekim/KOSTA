/**
 * 
 */
package org.kosta.webstudy23.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.webstudy23.model.ProductDAO;
import org.kosta.webstudy23.model.ProductVO;

public class RegisterProductController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//id는 sequence, regdate는 sysdate로 자동발급되어 3개의 데이터만 필요
		String name = request.getParameter("name");
		String maker = request.getParameter("maker");
		String price = request.getParameter("price");
		//강사님 풀이
		//int price = Integer.parseInt(request.getParameter("price"));
		ProductVO pvo = new ProductVO(name, maker, Integer.parseInt(price));
		ProductDAO.getInstance().registerProduct(pvo);
		//redirect 방식으로 이동시켜 재등록되지 않도록 한다
		//등록결과 화면에서 alert로 등록완료 메세지를 보여준 후 상품리스트 페이지로 이동되도록 처리해본다 
		//원래코드 
		return "redirect:register-result.jsp";
		
		//문제 1>
		//해결 1> 등록 결과화면 대신 상품리스트를 제공하는 컨트롤러로 리다이렉트 시킨다
		//return "redirect:AllProductListController.do";
	}

}
