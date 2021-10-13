package org.kosta.webstudy19.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.webstudy19.model.MockDAO;

public class RegisterCarController implements Controller {
	//forward 방식 
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String carInfo = request.getParameter("carInfo");
		MockDAO.getInstance().registerCar(carInfo);
		//계속 등록이 되면 안되기 때문에(console에 계속 출력)
		//forward 방식이 아니라 redirect 방식으로 이동시키고자 할때는
		//redirect: 을 경로 앞에 명시한다 
		return "redirect:registercar-result.jsp";
	}

}
