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
	/*
	 * step5 version create method를 개선
	 * 실행 시에 클라이언트가 전달한 command를 이용해 동적으로 객체를 생성
	 * 컨트롤러 구현 객체가 추가도리 때 코드를 변경하지 않아도 된다는 장점
	 */
	public Controller create(String command) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		//현재 패키지 정보를 받아온다
		//String packageName = this.getClass().getPackage().getName();
		//client가 전달한 command가 실제컨트롤러 클래스명이므로 패키지 정보에 추가한다
		//String classInfo = packageName + "." + command;
		
		//StringBuilder는 문자열 하나만 잡히기 때문 toString() 사용
		//StringBuilder : 가변,
		String classInfo = new StringBuilder(this.getClass().getPackage().getName()).append(".").append(command).toString();
		//Reflction API를 이용해 동적으로 객체를 생성
		//예외처리 : try/ catch 보다는 throws : controller 객체 생성시 문제 발생하면 콘솔에서 메세지 확인해야 하기 때문
		Controller controller = (Controller) Class.forName(classInfo).newInstance();
		return controller;
	}
	
	
	/*
	public Controller create(String command) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		//현재 패키지 정보를 받아온다
		String packageName = this.getClass().getPackage().getName();
		//client가 전달한 command가 실제컨트롤러 클래스명이므로 패키지 정보에 추가한다
		String classInfo = packageName + "." + command;
		//Reflction API를 이용해 동적으로 객체를 생성
		//예외처리 : try/ catch 보다는 throws : controller 객체 생성시 문제 발생하면 콘솔에서 메세지 확인해야 하기 때문
		Controller controller = (Controller) Class.forName(classInfo).newInstance();
		return controller;
	}
	
	*/
	/*	< step4 version create 코드 >
	
	public Controller create(String command) {
		Controller controller = null;
		//개별 컨트롤러 객체 생성 로직
		//서비스가 늘어날수록 create() 메서드가 계속 추가적으로 변경되어야 한다 --> step5 에서 Refactoring
		
		if(command.equals("findCustomerById"))
			controller = new FindCustomerByIdController();
		else if(command.equals("registerCustomer"))
			controller = new RegisterCustomerContorller();
		else if(command.equals("updateCustomer"))
			controller = new UpdateCustomerContorller();
		
		return controller;
	}
	*/
}
