package org.kosta.myproject.model.service;

import org.kosta.myproject.model.domain.MemberVO;
import org.kosta.myproject.model.domain.PointVO;

public interface MemberService {

	MemberVO findMemberById(String id);

	PointVO findPointById(String id);

	void register(MemberVO memberVO,PointVO pointVO);	
}