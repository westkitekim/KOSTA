package org.kosta.webstudy19.model;
//실제 DAO가 아닌 모조 객체를 사용하기 때문에 MockDAO라고 정한다 - 관례

import java.util.ArrayList;

//Singleton Design Pattern : 시스템 상에서 단 한번 객체를 생성해서 공유해 사용하는 디자인 패턴
public class MockDAO {// 모조  DAO를 만들어서 간단히 테스트
	private static MockDAO instance = new MockDAO();
	private MockDAO() {}
	public static MockDAO getInstance() {
		return instance;
	}
	public String findCarInfo(String carNo) throws Exception{
		if(carNo.equals("1234")) 
			return "캐스퍼 검정";
		else 
			return null;
	}
	public ArrayList<String> findCarListByMaker(String maker) throws Exception{
		ArrayList<String> list = new ArrayList<String>();
		if(maker.equals("현대")) {
			list.add("캐스퍼");
			list.add("아반떼");
			list.add("소나타");
		}
		return list;
	}
	public void registerCar(String carInfo) throws Exception {
		System.out.println(carInfo + " 등록완료.. database에 저장");
	}
}
