package org.kosta.webstudy20.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 컨트롤러 로직을 수행하는 개별 컨트롤러 객체를 캡슐화, 표준화, 다형성을 지원하기 위한 인터페이스
 */
public interface Controller {
	/**
	 * return 하는 String은 클라이언트에게 응답하기 위한 view path 정보
	 * forward 방식일때는 return "findbyid-ok.jsp"; 와 같이 view path 정보를 반환
	 * redirect 방식일때는 return "redirect:register-result.jsp"와 같이 redirect: 를 서두에 추가하여 반환
	 */
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
