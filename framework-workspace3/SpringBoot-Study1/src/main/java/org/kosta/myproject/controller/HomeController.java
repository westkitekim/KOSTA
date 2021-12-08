package org.kosta.myproject.controller;

import org.springframework.stereotype.Controller;
//디렉토리 주의
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class HomeController {
	//port 다음을 의미 
	//localhost:7777 다음을 의미
	//@RequestMapping("/")
	//부트에서는 .do안씀
	@RequestMapping(value={"/", "home"})//여기 설명 무엇인가..
	public String home() {
		System.out.println("SpringBoot-Study1 home");//controller 실행되는 것을 확인
		return "home";
	}
}
