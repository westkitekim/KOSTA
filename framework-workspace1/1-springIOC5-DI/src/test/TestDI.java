package test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.MemberService;

public class TestDI {
	public static void main(String[] args) {
		//설정파일 인자로 넣어줘야 bean 객체 생성
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("spring-config.xml");
		MemberService ms = (MemberService)factory.getBean("memberService");//DL
		ms.registerMemberAndPoint("아이유 오리", "cgv 10000");
		//dbcp test
		//dbcp 객체 반환되는지 확인 -> org.apache.commons.dbcp2.BasicDataSource@cd2dae5 출력
		//내가 만들지 않아도 충분히 객체를 만들어 사용가능
		System.out.println(factory.getBean("dbcp"));
		factory.close();
	}
}
