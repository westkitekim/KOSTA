package model;

public interface MemberService {
	/**
	 * 회원 등록 서비스<br>
	 * 1. 회원 정보 등록 <br>
	 * 2. 포인트 정보 등록<br>
	 * 위의 기능들을 트랜잭션 처리(회원가입시 반드시 포인트를 지급할 수 있도록! 트랜잭션 처리!) 
	 * @param memberInfo
	 * @param pointInfo
	 */
	void registerMemberAndPoint(String memberInfo, String pointInfo);
}
