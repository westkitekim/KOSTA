package org.kosta.webstudy23.controller;
/*
 * 컨트롤러 객체 생성을 전담하는 Factory 객체
 */
public class HandlerMapping {
	private static HandlerMapping instance = new HandlerMapping();
	private HandlerMapping() {}
	public static HandlerMapping getInstance() {
		return instance;
	}
	/*
	 * Reflection API : 런타임시에 객체를 제어하기 위한 API
	 * Reflection API를 이용해 동적으로 컨트롤러 객체를 생성
	 */
	public Controller create(String command) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		String packageInfo = this.getClass().getPackage().getName();
		String classInfo = new StringBuilder(packageInfo).append(".").append(command).toString();
		return (Controller) Class.forName(classInfo).newInstance();//exception은 throws
	}
}
