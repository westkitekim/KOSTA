package org.kosta.webstudy21.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// Exception throws 
// 컨트롤러 구현체들이 implements 해야하는 인터페이스
// 계층구조 형성을 통한 다형성 지원 ( 개별 컨트롤러 객체들을 실행하는 FrontControllerServlet(사용자측) 은 
// 개별 컨트롤러 객체가 아닌 인터페이스의 단일한 메세지 방식으로 다양한 개별 컨트롤러 객체들을 실행할 수 있다
// 표준화 
public interface Controller {
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
