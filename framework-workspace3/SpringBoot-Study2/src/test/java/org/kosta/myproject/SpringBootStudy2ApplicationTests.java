package org.kosta.myproject;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.kosta.myproject.model.mapper.DepartmentMapper;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest//내부적으로 jUnit 설정을 처리해준다
class SpringBootStudy2ApplicationTests {
	
	@Resource//@Autowired와 동일한 역할 
	private DepartmentMapper deptMapper;
	
	@Test
	void contextLoads() {
		
	}
	
	@Test
	void deptCount() {
		System.out.println("부서 수: " + deptMapper.getTotalDepartmentCount());
	}
}
