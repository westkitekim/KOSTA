package org.kosta.webstudy19.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.webstudy19.model.MockDAO;

//실제 컨트롤러 로직을 수행하는 개별 컨트롤러 객체(컨트롤러 인터페이스 계층구조하에 편입) 
public class FindCarByNoController implements Controller {

	// 반환타입 String 은 우리가 사용했던 path - 이동할 경로 나타낸다
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 차량번호로 차 정보 검색
		String carNo = request.getParameter("carNo");// findcar-form.jsp의 name값 인자
		String carInfo = MockDAO.getInstance().findCarInfo(carNo);
		String path = null;
		// 예외를 발생시켜 본다, error.jsp페이지가 실행되는 것을 확인
		// String str = null;
		// System.out.println(str.length());

		if (carInfo != null) {
			request.setAttribute("carInfo", carInfo);
			path = "findcar-ok.jsp";
		} else {
			path = "findcar-fail.jsp";
		}
		return path;
	}

}
