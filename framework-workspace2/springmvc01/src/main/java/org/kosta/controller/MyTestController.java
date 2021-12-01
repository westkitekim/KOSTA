package org.kosta.controller;

import javax.servlet.http.HttpSession;

import org.kosta.model.CustomerDTO;
import org.kosta.model.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyTestController {
	//Legacy
	@RequestMapping("hello.do")
	public ModelAndView myTest() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result1");//ViweResolver에 의해 /WEB-INF/views/result1.jsp로 응답한다
		mv.addObject("info", "Hello SpringMVC");//request.setAttribute("info", "")와 동일
		return mv;
	}
	
	//Current(많이 사용되는 방법)
	//위의 컨트롤러 개발스타일을 아래와 같이 표현할 수도 있다 
	@RequestMapping("hi.do")
	public String hi(Model model) {
		//ModelAndView 객체를 만들지 않고 핸들러에게 달라고함 
		model.addAttribute("info", "Hi SpringMVC");
		return "result1";
	}
	
	@RequestMapping("paramTest1.do")
	//인자값인 @RequestParam String customerId가 request.getParameter() 역할을 한다
	//HandlerAdapter(ReuquestMappingHnadleAdapter)가 컨트롤러 실행 시 
	//매개변수에 알맞는 데이터를 생성해 전달해준다
	//@RequestParam은 매개변수명이 form data의 name과 일치한다면 생략가능
	//public String paramTest1(@RequestParam String customerId, Model model) {
	public String paramTest1(String customerId, Model model) {
		model.addAttribute("customerName", "아이유");
		return "result2";
	}
	
	//spring 4.3이상부터 RequestMapping 사용가능? 
	@RequestMapping("paramTest2.do")
	//정보할당하기 위해 Model 객체 사용?
	public String paramTest2(String userName, String userAddress, Model model) {
		model.addAttribute("message", "고객 정보 등록완료");
		return "result3";
	}
	
	//배열로 데이터 가져오기 
	@RequestMapping("paramTest3.do")
	//getParameterValues() : String 반환값?
	//HandlerAdapter가 request.getParameterValues() 처리해서 배열로 전달한다 
	//매개변수의 타입을 받아서 그것에 맞는 객체생성(Reflection API)
	public String paramTest3(String[] hobby) {
		for(int i = 0; i < hobby.length; i++)
			System.out.println(hobby[i]);//console에서 확인
		return "result4";
	}
	
	//Spring Ver4.3 버전 미만일 때는 아래와 같이 요청방식을 제한할 수 있다
	//post방식만 지원하도록 구현한 메서드
	@RequestMapping(method=RequestMethod.POST, value="methodTest1.do")
	public String methodTest1() {
		System.out.println("POST방식만 가능");
		return "result4";
	}
	
	//Spring Ver4.3 이상일 때는 아래와 같이 더 간단하게 요청방식을 제한할 수 있다
	@PostMapping("methodTest2.do")
	public String methodTest2() {
		return "result4";
	}
	
//**********211130************************************************
	
	//GET 방식만 허용하고자 할 때 4.3 이상에서 아래 어노테이션을 지원
	//@GetMapping("paramTest4.do") //405 Error
	
	//HandlerAdapter가 아래의 매개변수에 맞게 폼데이터를 객체로 생성해서 전달한다
	//내부적으로 requestmapping, getparameter작동? 
	//포스트 방식일 때는 request body 에 담겨서 별도의 인코딩이 필요(부트는 자동이지만 레거시는 설정해줘야함) 
	//web.xml에서 코드 수정하는데 서블릿의 filter를 사용한다
	
	//컨트롤러 핸들러어댑터가 cutomerDTO 객체 생성 
	//타입을 보고 만드는 거라서 매개변수명은 상관 없음
	//컨트롤러에서 받는 애들은 뷰에서 바로 사용 가능 - 객체가 생성되었기 때문
	
	@PostMapping("paramTest4.do")
	public String paramTest4(CustomerDTO customer) {//CustomerDTO 객체는 view에서 소문자로 시작하는 클래스명으로 공유되어 사용가능
		System.out.println(customer);
		return "result4";
	}
	
	/*
	 	▣ Redirect Test
	 	  - spring의 redirect 방법은 "redirect:"로 접두사를 사용한다는 점에서 동일
	 	  - redirect 방식은 ViewResolver를 거치지 않기 때문에 한 번 더 거치는 작업이 필요
	 	  - why? : DispatcherServlet을 무조건 지나가도록 하기 위해 view page를 
	 	  		   /WEB-INF/view/ 하위에 두어서 클라이언트 브라우저가 직접 접근할 수 없기 때문
	 	  - Conclusion : spring에서 redirect할 때는 반환하는 url의 매핑(?)을 한 번 더 해준다
	 	  				 -> 한 번 더 거치는 것..? 
	 	  				 //상품등록, 회원가입, 로그인 등 재동작하면 안좋은 것들(새로운 요청 동작)
	 */
	@PostMapping("redirectTest.do")
	public String redirectTest(CustomerDTO customer) {
		System.out.println(customer);
		//1. 기존 방식 
		//아래 방식은 클라이언트(브라우저)가 직접 jsp에 접근할 수 없도록 구조(WEB-INF 아래 디렉토리)를 정의했으므로 error : 404에러
		//이유는 Front Controller Pattern : 모든 클라이언트의 요청은 DispatcherServlet을 통하도록 해야하기 때문
		//return "redirect:result5.jsp";
		
		//2. 아래와 같이 명시해야한다
		//Controller로 다시 가서 다시 jsp로 이동하게 만드는 것
		//return "redirect:testResult.do";//springmvc에서 redirect 방식으로 응답할 때는 서두에 redirect: 을 명시한다
		
		//querystring 방식
		return "redirect:testResult.do?customerId=" + customer.getId();//springmvc에서 redirect 방식으로 응답할 때는 서두에 redirect: 을 명시한다
	}
	//querystring 방식
	@RequestMapping("testResult.do")
	public String testResult(String customerId) {
		System.out.println(customerId);
		return "result5";
	}
	
//	@RequestMapping("testResult.do")
//	public String testResult() {
//		return "result5";
//	}
	
	@PostMapping("hasA-test.do")
	public String testHas(UserDTO user) {
		System.out.println(user + " db insert");
		return "result5";
	}
	
	@PostMapping("login.do")
	//session 사용시 HttpSession를 매개변수로 받아서 사용한다
	//session에 들어가는 정보는 모두 직렬화!!! -> 자동 저장
	public String login(String id, String password, HttpSession session) {
		System.out.println(id + " " + password + " 로그인");
		session.setAttribute("cvo", new CustomerDTO(id, "아이유", "분당"));
		return "result6";
	}
}










































