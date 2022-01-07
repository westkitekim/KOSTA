package org.kosta.myproject.controller;

import javax.annotation.Resource;

import org.kosta.myproject.model.domain.PointVO;
import org.kosta.myproject.model.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class PointController {
	@Resource
	private MemberService memberService;
	@RequestMapping("findPointById")
	public ModelAndView findPointById(String id) {
		PointVO pvo=memberService.findPointById(id);
		if(pvo==null) {
			return new ModelAndView("find-point-result");
		}else {
			return new ModelAndView("find-point-result","pointVO",pvo);
		}
	}
}
