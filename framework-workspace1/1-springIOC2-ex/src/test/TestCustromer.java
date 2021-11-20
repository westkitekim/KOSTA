package test;

import model.KalTicketService;

public class TestCustromer {
	public static void main(String[] args) {
		//AsianaTicketService service = new AsianaTicketService();
		//service.asianaTicketing();
		//만약 항공사를 변경해야 한다면 
		KalTicketService service = new KalTicketService();
		service.kalTicketing();
		//위와 같이 객체 생성부 및 기능 호출부를 변경해야 한다
		//의존하는 컴포넌트를 변경하기 위해서는 사용하는 측의 코드 영역 변경이 불가피하다
		//결합도가 높은 상태
		//티켓서비스 사용하는 클라이언트 코드가 100가지가 있다면 그 100가지 모두를 변경해야 하기 때문에 생산성 하락
		
		
	}
}
