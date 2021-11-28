package model;
/*
 * Service : 비즈니스(서비스) 계층의 컴포넌트 
 * 			 트랜잭션 처리를 위한 컴포넌트
 * MemberServiceImpl 은 MemberDAOImpl을 필요로 한다
 */
public class MemberServiceImpl implements MemberService {
	//느슨한 결합도를 위해 인터페이스 타입으로 참조(구현체로 참조하면 왜 결합도가 높아지는가?-구현체가 바뀌면 모두 바뀌어야 하기 때문)
	private MemberDAO memberDAO;
	//xml or annotation으로 구현
	//스프링 IOC(or DI ) Container에서 memberDAO 구현체를 주입한다 -> Dependency Injection, DI
	public MemberServiceImpl(MemberDAO memberDAO) {
		super();
		this.memberDAO = memberDAO;
	}
	@Override
	public String findMemberById(String id) {
		return memberDAO.findMemberById(id);
	}
	
	
}
