package org.kosta.myproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")//port까지 명시하면 해당 메서드가 동작함(ex.localhost:7777/)
	public String home() {
		return "index";
	}
}
