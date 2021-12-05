package model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *	Service : 비즈니스 계층, 비즈니스 로직을 정의, 트랜잭션 처리(비즈니스 로직을 정의하면 반드시 트랜잭션 처리도 함)
 */
@Service
public class MemberServiceImpl implements MemberService {
	//DAO 인스턴스 생성
	private MemberDAO memberDAO;
	private PointDAO pointDAO;
	//생성자를 통한 DI, 의존성 주입
	@Autowired
	public MemberServiceImpl(MemberDAO memberDAO, PointDAO pointDAO) {
		super();
		this.memberDAO = memberDAO;
		this.pointDAO = pointDAO;
	}
	@Override
	public void registerMemberAndPoint(String memberInfo, String pointInfo) {
		// 트랜잭션 처리는 이후 공부 예정
		// 여러 개의 정보를 등록하려는 경우, 여러 개의 DAO 사용
		memberDAO.register(memberInfo);
		pointDAO.register(pointInfo);
	}

}
