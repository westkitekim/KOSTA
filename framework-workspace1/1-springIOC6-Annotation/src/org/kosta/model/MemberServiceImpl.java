package org.kosta.model;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
// 비즈니스 계층에 명시하는 컴포넌트 계열 어노테이션, Spring Container에 의해 소문자로 시작하는 클래스명을 id로 하는 bean이 생성된다/
@Service
public class MemberServiceImpl implements MemberService {
	//2. 필드를 통한 주입(iv로 주입도 가능)
	//Dependency Injection : 생성자를 통한 의존성 주입
	//@Autowired 는 스프링 컨테이너에 생성된 bean 중에 일치되는 타입의 bean(객체)을 주입, DI계열
	//@Autowired
	
	//3. @Resource 어노테이션도 동일한 역할 
	//@Resource
	
	//에러났던 지점(MemberDAOImpl2 DAO 2개 이상 만든 경우) 
	//4. @Autowired 와 @Resource는 타입을 이용해 일치되는 bean을 주입하는 방식으로 
	//하나의 인터페이스를 여러 개의 클래스가 구현하는 경우에는 BeanCreationException과 NoUniqueBeanDefinitionException 이 발생된다.
	//이 경우에는 @Autowired 에 @Qualifier(bean id) 를 추가하거나 @Resource(name=bean id)를 추가 명시하면 된다.
	
	//4-1
	//@Autowired
	//@Qualifier("memberDAOImpl2")
	
	//4-2 (4-1과 동일) 
	@Resource(name="memberDAOImpl2")
	private MemberDAO memberDAO;
	//권장하는 형태는 생성자 만들기
	//Dependency Injection : 생성자를 통한 의존성 주입
	//@Autowired 는 스프링 컨테이너에 생성된 bean 중에 일치되는 타입의 bean(객체)을 주입
	
	/* 1. 생성자를 통한 주입(테스트 하기엔 생성자를 사용하는 것이 더 유리하다 -> 이 객체를 다른 객체로 만들어 테스트 해볼 수 있기 때문)
	@Autowired
	public MemberServiceImpl(@Qualifier("memberDAOImpl2")MemberDAO memberDAO) {
		super();
		this.memberDAO = memberDAO;
		//정말 주입되는지 log 찍어보기
		System.out.println("DI:" + memberDAO);
	}
	*/
	
	@Override
	public void register(String memberInfo) {
		//System.out.println(getClass().getName() + " register");
		memberDAO.register(memberInfo);
	}
	
}
