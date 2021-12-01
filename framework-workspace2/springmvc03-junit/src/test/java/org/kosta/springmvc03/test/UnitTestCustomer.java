package org.kosta.springmvc03.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kosta.springmvc02.model.dto.CustomerDTO;
import org.kosta.springmvc02.model.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.junit.Assert;//import code 확인(에러 가능)
//java 단위테스트(jUnit)를 위한 어노테이션
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring-model.xml"})//해당 설정파일을 로드함
public class UnitTestCustomer {
	//test의 장점 : 바로 DI 가능
	@Autowired
	private CustomerMapper mapper;
	@Test
	public void mapperTest() {
		System.out.println(mapper);//주입받은 주소값 확인 org.apache.ibatis.binding.MapperProxy@25fb8912
		
	}
	
	@Test
	public void customerCount() {//메서드 단위로 테스트 가능(커서 두고 run as) 
		//System.out.println(mapper.getTotalCustomerCount());
		//jUnit 클래스 Assert로 테스트
		//import org.junit.Assert; 추가, import가 잘 안되는 경우 있음
		Assert.assertEquals(2, mapper.getTotalCustomerCount());//1번째 매개변수: 기대값, 2번째 매개변수: 실제값, 결과 일치시 그린라이트
		
		//일치하지 않으면 java.lang.AssertionError: expected:<3> but was <2> 출력
		//Assert.assertEquals(2, mapper.getTotalCustomerCount());//1번째 매개변수: 기대값, 2번째 매개변수: 실제값, 결과 일치시 그린라이트
	}
	
	@Test
	public void findCustomerById() {
		//판별 방법 1. Console 출력
		//System.out.println(mapper.findCustomerById("java"));
		
		//판별 방법 2. Assert 클래스의 assert 메서드 사용
		//Assert class의 assert method : 단정메서드로 테스트 케이스의 수행결과를 판별 
		Assert.assertNotNull(mapper.findCustomerById("java"));//그린라이트: 존재하는 id
		//Assert.assertNotNull(mapper.findCustomerById("java2"));//java.lang.AsserionError
	}
	
	@Test
	public void registerCustomer() {
		mapper.registerCustomer(new CustomerDTO("springmvc", "이강인", "마요르카"));
		System.out.println(mapper.findCustomerById("springmvc"));
	}
}

















