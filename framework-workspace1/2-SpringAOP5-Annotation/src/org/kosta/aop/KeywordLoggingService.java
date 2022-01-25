package org.kosta.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//AOP Annotation 적용 예제 , xml에서 <aop:config>??
@Aspect // AOP 담당 객체임을 알리는 어노테이션, 얘는 서비스도 아니고 Repository도 아니로 Controller에도 영역을 잡지 않겠다 하면 Component로 명시
@Component // bean 생성을 위한 어노테이션, AOP 담당객체 생성
public class KeywordLoggingService {
	
	private Logger log = LogManager.getLogger();
	/*
	 * AOP Annotation 설정
	 * @Before : core 실행 전에 적용되는 advice
	 * pointcut : public - 접근제어자 public
	 * 			  * - return type 모두 허용
	 * 			  org.kosta.model.service - 해당 패키지 하위 요소
	 * 			  *Service - Service로 마치는 인터페이스 또는 클래스
	 * 			  find* - find로 시작되는 메서드들
	 * 			  (..) - 0 ~ n 개의 매개변수
	 */
	@Before("execution(public * org.kosta.model.service.*Service.find*(..))")//메서드 실행 전 동작되는 advice
	public void logging(JoinPoint point) {
		System.out.println();
		//core 의 클래스명, 메서드명
		String cn = point.getTarget().getClass().getName();
		String mn = point.getSignature().getName();
		//core에서 전달받는 매개변수의 인자값들을 반환받는다
		Object[] params = point.getArgs();
		String keyword = "";
		
		for(int i = 0; i < params.length; i++) {
			keyword += params[i] + " ";
		}
		log.info(cn + " " + mn + " " + keyword);
	}
}
