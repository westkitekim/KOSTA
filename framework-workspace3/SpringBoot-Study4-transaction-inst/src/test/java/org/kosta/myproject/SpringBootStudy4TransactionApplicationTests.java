package org.kosta.myproject;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.kosta.myproject.model.mapper.MemberMapper;
import org.kosta.myproject.model.mapper.PointMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootStudy4TransactionApplicationTests {@Resource
	MemberMapper memberMapper;
	@Autowired
	PointMapper pointMapper;
	@Test
	void contextLoads() {
		System.out.println(memberMapper.findMemberById("java"));
		System.out.println(pointMapper.findPointById("java"));
	}
}
