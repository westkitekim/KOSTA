package test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.MemberService;
/*
 * main method 가 있는 클래스를 클라이언트라고 생각,
 * 구현체가 전혀 변경되지 않는다
 */
public class TestDI {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("spring-config.xml");
		MemberService memberService = (MemberService)factory.getBean("memberService");//DL(Dependency Lookup)
		System.out.println(memberService.findMemberById("java"));
		factory.close();
	}
}
