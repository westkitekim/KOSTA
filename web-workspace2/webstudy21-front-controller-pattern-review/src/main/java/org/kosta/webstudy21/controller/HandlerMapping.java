package org.kosta.webstudy21.controller;

public class HandlerMapping {
	private static HandlerMapping instance = new HandlerMapping();
	private HandlerMapping() {}
	public static HandlerMapping getInstance() {
		return instance;
	}
	/*
	 * reflection API를 이용해 런타임시에 동적으로 객체를 생성
	 */
	public Controller create(String command) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		//패키지명을 받아온다
		String packageInfo = this.getClass().getPackage().getName();
		//클래스명을 패키지명에 추가한다
		String classInfo = new StringBuilder(packageInfo).append(".").append(command).toString();
		//String productInfo = new StringBuilder(this.getClass().getPackage().getName()).append(".").append(command).toString();
		//Controller controller = (Controller) Class.forName(classInfo).newInstance();
		return (Controller)Class.forName(classInfo).newInstance();
		
	}
}
