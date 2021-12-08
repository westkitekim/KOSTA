package org.kosta.myproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
 *	@SpringBootApplication : 스프링 부트 프로젝트의 기본적인 설정 선언
 *							 내부적으로 @ComponentScan 역할 : IOC, DI, DL
 *							 컴포넌트 계열 어노테이션을 Bean으로 생성, DI 관련 어노테이션은 DI 처리한다
 *							 
 *							 @EnableAutoConfiguration : 사전에 정의된 (Maven pom.xml) 라이브러리들을 
 *														Bean으로 등록 -> 자동설정(springmvc, mybatis, aop, transaction 등에 대한 자동설정을 담당)
 *
 *							 base package는 현 패키지가 되므로 
 *							 현 패키지 또는 현 패키지의 하위에서 application을 정의하고 어노테이션을 정의해야
 *							 반영이 된다. ★★★★★★★★★★★★★★★★★★★★
 *
 *							 모든 설정을 자동화! 
 *							 현 패키지가 ROOT가 되어야 함 
 */
@SpringBootApplication
public class SpringBootStudy2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootStudy2Application.class, args);
	}

}
