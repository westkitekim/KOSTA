package step1.unit.test;
// Class.forName 메서드의 역할을 확인하는 예제 
//  - 
public class TestClass {
	public static void main(String[] args) {
		String myDriver = "step1.unit.driver.MyDriver";//존재하지 않는 클래스면 예외 발생
		try {
			Class.forName(myDriver);//MyDriver class loading -> static 영역 실행되고 메모리(meta space)에 적재
									//클래스 로딩하는 메서드이기 때문에 static 가 실행된다 
			System.out.println("**MyDriver class loading**");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
