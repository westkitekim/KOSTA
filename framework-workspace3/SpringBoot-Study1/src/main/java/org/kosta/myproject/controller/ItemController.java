package org.kosta.myproject.controller;

import org.kosta.myproject.model.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ItemController {
	private ItemMapper itemMapper;
	
	//생성자로 주입하는 습관!!
	@Autowired
	public ItemController(ItemMapper itemMapper) {
		super();
		this.itemMapper = itemMapper;
	}

	@RequestMapping("getTotalItemCount")
	public String getTotalItemCount(Model model) {
		model.addAttribute("totalItemCount", itemMapper.getTotalItemCount());
		return "item-count";
	}
}
