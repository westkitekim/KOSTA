package model;
// ★★★JSP EL에서 접근해 사용가능한 메서드는 get계열의 메서드와 is계열 메서드만 가능
public class TestVO {
	private String id;
	//JSP EL에서 접근가능
	public String getName() {
		System.out.println("TestVO getName() 실행");
		return "아이유";
	}
	//JSP EL에서 접근불가, get 과 is계열의 메서드 이외는 접근불가
	public String findInfo() {
		return "짜장면";
	}
	//JSP EL에서 접근가능
	public boolean isExist() {
		
		return false;
	}
}
