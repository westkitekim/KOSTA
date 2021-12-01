package org.kosta.springmvc04.controller;

import org.kosta.springmvc04.model.domain.ItemDTO;
import org.kosta.springmvc04.model.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	private ItemMapper itemMapper;
	
	@Autowired
	public HomeController(ItemMapper itemMapper) {
		super();
		this.itemMapper = itemMapper;
	}
	
	@RequestMapping("home.do")
	public String home(Model model) {//setattribute 역할 : Model 객체
		model.addAttribute("totalItemCount", itemMapper.getTotalItemCount());
		return "index";
	}
	
	@RequestMapping("findItemByNo.do")
	//매개변수 itemNo는 jsp의 name과 일치
	public String findItemByNo(int itemNo, Model model) {
		String viewName = null;
		ItemDTO item = itemMapper.findItemByNo(itemNo);
		if(item == null) {
			viewName = "findbyno-fail";
		}else {
			viewName = "findbyno-success";
			model.addAttribute("itemDTO", item);
		}
		return viewName;
	}
	
	@GetMapping("getAllItemList.do")
	public String getAllItemList(Model model) {
		model.addAttribute("itemList", itemMapper.getAllItemList());
		return "item-list";
	}
	
	@PostMapping("registerItem.do")
	public String registerItem(ItemDTO itemDTO, Model model) {
		itemMapper.registerItem(itemDTO);
		//querystring으로 보내는 이유? - 요청이 사라지기 때문
		return "redirect:registerItemResult.do?itemNo=" + itemDTO.getItemNo();
	}
	
	@RequestMapping("registerItemResult.do")
	public String registerItemResult(int itemNo, Model model) {//매개변수를 위의 쿼리스트링과 맞춰준다
		model.addAttribute("itemDTO", itemMapper.findItemByNo(itemNo));
		return "register-item-result";
	}
	
	
}
