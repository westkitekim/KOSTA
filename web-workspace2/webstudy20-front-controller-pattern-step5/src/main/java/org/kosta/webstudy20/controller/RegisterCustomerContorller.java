package org.kosta.webstudy20.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.webstudy20.model.MockDAO;

public class RegisterCustomerContorller implements Controller {
	/*
	 * index 의 등록 폼에서 전달한 customerInfo를 받아온다 
	 * MockDAO 의 registerCustomer() 를 이용해 등록한다
	 * 결과화면을 보여주기 위해 register-result.jsp 로 redirect 방식으로 응답하기 위해 return 한다
	 * return redirect: 으로 시작되는 경로를 리턴한다
	 */
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String customerInfo = request.getParameter("customerInfo");
		MockDAO.getInstance().registerCustomer(customerInfo);//등록하는 것이라 반환값 없음(해당 메서드 확인할 것)
		return "redirect:register-result.jsp";
	}

}
