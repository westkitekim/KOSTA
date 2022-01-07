package org.kosta.myproject.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.myproject.model.domain.MemberVO;

@Mapper
public interface MemberMapper {
	int getMemberCount();
	MemberVO findMemberById(String id);
	void registerMember(MemberVO memberVO);
}
