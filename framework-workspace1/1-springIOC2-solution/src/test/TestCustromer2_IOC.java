package test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.KalTicketServiceImpl;
import model.TicketService;

public class TestCustromer2_IOC {
	public static void main(String[] args) {
		//1. 기존 제어 방식 : 필요한 컴포넌트를 생성해서 사용 
		//AsianaTicketService service = new AsianaTicketService();
		//service.asianaTicketing();
		//만약 항공사를 변경해야 한다면 
		//KalTicketService service = new KalTicketService();
		//service.kalTicketing();
		//위와 같이 객체 생성부 및 기능 호출부를 변경해야 한다
		//의존하는 컴포넌트를 변경하기 위해서는 사용하는 측의 코드 영역 변경이 불가피하다
		//결합도가 높은 상태
		//티켓서비스 사용하는 클라이언트 코드가 100가지가 있다면 그 100가지 모두를 변경해야 하기 때문에 생산성 하락
		
		//IOC 적용 -> 결합도를 느슨하게 한다
		//구체적인 항공사가 변경되어도 ( 컴포넌트(bean) 가 변경되어도 사용하는 측에서는 변경 필요 x ) 
		//외부 영향이 최소화된다
		//naming rule : interface를 구현하는 구현체는 접미사로 Impl을 붙인다
		
		//1. 대상 컴포넌트들의 계층구조를 형성 : 인터페이스 TicketService 추상메서드 ticketing
		//bean 이 되는 애가 interface 가 되어야 함
		
		//2. spring 설정(IOC)을 통해 spring ioc container에게 컴포넌트(bean) 생성할 것을 명시
		//spring(IOC) 설정은 xml과 annotation 방식이 있다
		
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("ioc.xml");
		//bean id를 이용한 검색을 통해 bean(or component or 의존성)을 확보 -> DL( Dependency Lookup )
		TicketService service = (TicketService) factory.getBean("ticket");//object 로 반환되므로 down casting 
		service.ticketing();
		factory.close();//자원을 쓰는 것이므로 닫아줘야 한다
		
		
	}
}
