package org.kosta.model.service;

import org.kosta.model.dao.MemberDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class MemberServiceImpl implements MemberService {
	
	private MemberDAO memberDAO;
	//별도의 DI 어노테이션을 명시하지 않아도 가능하긴 하나 연습용으로 다 작성해보기
	@Autowired
	public MemberServiceImpl(MemberDAO memberDAO) {
		super();
		this.memberDAO = memberDAO;
	}
	@Override
	public void deleteMember(String id) {
		memberDAO.deleteMember(id);
	}
	@Override
	public String findByName(String name) {
		return memberDAO.findByName(name);
	}
	@Override
	public String findByAddress(String address) {
		return memberDAO.findByAddress(address);
	}

}
