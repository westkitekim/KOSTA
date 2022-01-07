package org.kosta.myproject.controller;

import javax.annotation.Resource;

import org.kosta.myproject.model.mapper.MemberMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@Resource
	private MemberMapper memberMapper;
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("memberCount", memberMapper.getMemberCount());
		return "home";
	}
}
