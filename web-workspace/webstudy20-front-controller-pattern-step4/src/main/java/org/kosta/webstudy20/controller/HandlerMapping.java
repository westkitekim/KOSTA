package org.kosta.webstudy20.controller;
/**
 * 컨트롤러 구현체 생성 전담 클래스 
 * 실제 컨트롤러 로직을 수행할 객체를 생성하는 클래스
 * 
 * 실제 담당자를 연결시켜준다 : Hander Mapping 
 * 이것을 생성하면 FrontControllerServlet이 가벼워진다, 수정할 필요없음 & 여러 개 만들 필요없음
 * 객체를 여러개 만들 필요가 없기 때문에 Singleton Design Pattern 적용
 */
public class HandlerMapping {
	private static HandlerMapping instance = new HandlerMapping();
	private HandlerMapping() {}
	public static HandlerMapping getInstance() {
		return instance;
	}
	public Controller create(String command) {
		Controller controller = null;
		//개별 컨트롤러 객체 생성 로직
		if(command.equals("findCustomerById"))
			controller = new FindCustomerByIdController();
		else if(command.equals("registerCustomer"))
			controller = new RegisterCustomerContorller();
		else if(command.equals("updateCustomer"))
			controller = new UpdateCustomerContorller();
		return controller;
	}
}

