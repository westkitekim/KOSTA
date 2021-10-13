package org.kosta.webstudy19.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 컨트롤러 구현체를 캡슐화하는 인터페이스(:표준화에 기여)
 * 
 * 구글이미지의 컨트롤러가 인터페이스, 디스패쳐서블릿이 프런트컨트롤러서블릿
 */
public interface Controller {
	//추상메서드 선언
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
