package org.kosta.model;
//Annotation 예제


//실제 어노테이션은 구현체에 붙인다. 객체 생성하기 때문
//bean 생성시 exception
import org.springframework.stereotype.Repository;
//영속성 계층의 bean 생성시 사용하는 어노테이션, spring container는 소문자로 시작하는 클래스명을 bean id로 저장한다.

@Repository
//기본적으로 생성되는 아이디가 아닌 다른 bean id로 설정하고자 할 때는 
//아래와 같이 하면 된다. -> getBean에서도 동일한 이름 사용
//@Repository("memberDAO")
public class MemberDAOImpl2 implements MemberDAO {
	@Override
	public void register(String memberInfo) {
		System.out.println(getClass().getName() + " version2 register " + memberInfo);
	}
}
