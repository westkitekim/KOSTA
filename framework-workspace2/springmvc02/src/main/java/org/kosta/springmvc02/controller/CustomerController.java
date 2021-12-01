package org.kosta.springmvc02.controller;

import org.kosta.springmvc02.model.dto.CustomerDTO;
import org.kosta.springmvc02.model.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {
	private CustomerMapper customerMapper;
	
	@Autowired//생성자 1개만 있어도 자동적으로 autowired 작동
	public CustomerController(CustomerMapper customerMapper) {
		super();
		this.customerMapper = customerMapper;
	}

	@RequestMapping("getTotalCustomerCount.do")
	public String getTotalCustomerCount(Model model) {
		model.addAttribute("totalCount", customerMapper.getTotalCustomerCount());
		return "customer-count";
	}
	
	//RequestMapping 은 GET,POST다 가능
	@RequestMapping("findCustomerById.do")
	public String findCustomerById(String id, Model model) {
		String viewName = null;
		CustomerDTO customerDTO = customerMapper.findCustomerById(id);
		if(customerDTO == null) {
			viewName = "findbyid-fail";
		} else {
			viewName = "findbyid-success";
			model.addAttribute("customerDTO", customerDTO);
		}
		return viewName;
	}
	
	@PostMapping("registerCustomer.do")
	public String registerCustomer(CustomerDTO customerDTO) {
		//중복확인
		if(customerMapper.findCustomerById(customerDTO.getId()) == null) {
			customerMapper.registerCustomer(customerDTO);
			return "redirect:registerResult.do";//Controller 를 통해서  redirect
		} else {
			return "duplicate-id";
		}
	}
	
	//결과는 GET..
	@GetMapping("registerResult.do")
	public String registerResult() {
		return "register-success";
	}
}

























