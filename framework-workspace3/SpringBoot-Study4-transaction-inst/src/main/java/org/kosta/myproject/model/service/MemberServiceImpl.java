package org.kosta.myproject.model.service;

import javax.annotation.Resource;

import org.kosta.myproject.model.domain.MemberVO;
import org.kosta.myproject.model.domain.PointVO;
import org.kosta.myproject.model.mapper.MemberMapper;
import org.kosta.myproject.model.mapper.PointMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service // 비즈니스 or 서비스 계층에 적용하는 어노테이션 
public class MemberServiceImpl implements MemberService {
	@Resource
	private MemberMapper memberMapper;
	@Resource
	private PointMapper pointMapper;
	@Override
	public MemberVO findMemberById(String id) {
		return memberMapper.findMemberById(id);
	}
	@Override
	public PointVO findPointById(String id) {
		return pointMapper.findPointById(id);
	}
	/**
	 * 트랜잭션(작업단위 or 업무단위) 제어 
	 * 등록작업은 세부적으로 회원 일반정보 등록과 포인트 일반정보 등록으로 구성된다 b
	 * 이 두 작업이 모두 정상적으로 수행되었을 때만 실제 db에 작업결과를 저장할 수 있도록 commit 하고  
	 * 만약 작업 중 문제가 발생한다면 rollback 처리되도록 한다 ( 작업취소하고 되돌리는 것을 의미 )
	 * 
	 *  만약 아래와 같이 문제가 발생할 경우 Transaction 처리를 통해 rollback 되도록 해야 한다 
	 *  별도의 트랜잭션 처리가 없으면 회원정보는 등록되고 포인트정보는 등록되지 않는다 -> 데이터 무결성 보장 안된다 
	 *  
	 *  @Transactional : AOP 기반 선언적 방식의 트랜잭션 처리 
	 *  				  컨트롤러에서 Spring Container로부터 MemberServiceImpl 객체가 아닌
	 *  				  AOP Proxy 객체가 DI(주입) 되어 해당 메서드에서 문제발생시 RollBack되고,
	 *  				  정상적으로 수행되면 commit 되게 한다
	 *  
	 *  ACID 트랜잭션 관리(일관성)
	 *  트랜잭션 처리를 한다는 것은 완벽하게 작업이 수행되었을 때 실제 디비에 반영,
	 *  하나라도 문제가 있다면 원상태로 롤백
	 */
	@Override
	@Transactional//★★★★★★★★★★★★
	public void register(MemberVO memberVO, PointVO pointVO) {
		memberMapper.registerMember(memberVO);
		//고의로 문제를 발생 
		//pointVO.setId(null);
		pointMapper.registerPoint(pointVO);
	}
}










