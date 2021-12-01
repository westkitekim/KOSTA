package org.kosta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
//Controller Annotation
@Controller
public class HomeController {
	
	//사용법1. 
//	ModelAndView객체 생성 - Model 정보와 연동한 View 정보 
//	@RequestMapping("home.do")
//	public ModelAndView home() {
		//첫 번째 인자 : view naeme, 두 번째 : attribute name, 세 번재 : attribute value
//		return new ModelAndView("index", "message", "Hello SpringMVC~");
//	}
	
	//사용법2.
	@RequestMapping("home.do")
	public String home(Model model) {
		//request.setAttribute와 동일한 표현
		model.addAttribute("message", "Hello SpringMVC~ 즐거운 한주~");//model 정보
		//springmvc-servlet.xml의 viewResolver 설정에 의해 
		//리턴하는 view name은 /WEB-INF/views/index.jsp로 찾아서 응답하게 된다. 앞에 /prefix에 따라 수정
		return "index";//view name
	}
	
}
