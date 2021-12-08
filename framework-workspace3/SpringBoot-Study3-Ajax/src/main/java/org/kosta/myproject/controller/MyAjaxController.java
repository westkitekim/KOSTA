package org.kosta.myproject.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kosta.myproject.model.domain.CustomerDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyAjaxController {
	
	@RequestMapping("testAjax1")
	@ResponseBody// Ajax 방식으로 응답하기 위한 어노테이션(페이지가 아니라 데이터로 응답되기 때문에 ViewResolver가 동작되지 않음)
	public String testAjax1(String userId) {
		return userId + " ajax response";//클라이언트에게 응답하는 데이터를 리턴한다
	}
	
	@RequestMapping("testAjax2")
	@ResponseBody
	//상식!!!★★★★★★★
	//DTO or VO 로 리턴하면 JSONObject로 응답한다(jackson databind 라이브러리에 의해 동작)
	//자동으로 어떤 라이브러리가 동작되는가? 
	public CustomerDTO testAjax2(String customerId) {
		return new CustomerDTO(customerId, "아이유", "오리");
	}
	
	@RequestMapping("testAjax3")
	@ResponseBody// List로 반환하면 JSONArray로 응답한다(jackson databind library)
	public List<String> testAjax3(String id) {
		List<String> list = new ArrayList<String>();
		list.add("화성행궁");
		list.add("잣향기푸른숲");
		list.add("융건릉");
		return list;
	}
	
	//List안에 단순 String이 아닌 객체가 들어오는 경우 has a 
	@RequestMapping("testAjax4")
	@ResponseBody// jackson databind에 의해 JSONArray >> JSONObject(JSONArray 안에 JSONObject가 들어가는 구조)
	public List<CustomerDTO> testAjax4(String id) {
		List<CustomerDTO> list = new ArrayList<CustomerDTO>();
		list.add(new CustomerDTO("java", "아이유", "오리"));
		list.add(new CustomerDTO("spring", "강하늘", "판교"));
		return list;
	}
	
	//Map으로 응답받는 방식
	@RequestMapping("testAjax5")
	@ResponseBody//Map을 JSONObject로 생성해서 응답한다
	public Map<String, Object> testAjax5(String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("CAR_NO", 123);//mybatis column 명으로 연습
		map.put("MODEL", "소나타");
		return map;
	}
	
	//Ajax 통신시 한글로 된 일반문자열로 응답할 경우
	//아래와 같이 @RequestMapping에서 별도의 한글처리가 필요(JSON(VO or DTO)은 필요없음)
	//or @RequestMapping("testAjax6") 도 지원이 됨 (UTF-8이 기본값으로 업데이트)
	@RequestMapping(value="testAjax6", produces="application/text;charset=utf-8")
	@ResponseBody
	public String testAjax6(String name, String address) {
		return "java 응답데이터";
	}
}



















