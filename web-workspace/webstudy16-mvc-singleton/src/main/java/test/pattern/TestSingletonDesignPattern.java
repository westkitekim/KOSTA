package test.pattern;
//Singleton Design Pattern 예제
public class TestSingletonDesignPattern {
	public static void main(String[] args) {
		//private 생성자이므로 compile error - 외부에서 사용 불가 
		//CompanyDAO dao = new CompanyDAO();
		
		//public static 메서드를 이용해 
		//CompanyDAO 객체의 주소값을 반환받는다
		//여러 번 실행하여 객체의 주소값이 1개로 동일한 것을 확인한다 - 3개의 객체가 생성되는 것이 아니라 1개의 객체만 생성 
		System.out.println(CompanyDAO.getInstance());
		System.out.println(CompanyDAO.getInstance());
		System.out.println(CompanyDAO.getInstance());
		
		//getCompanyInfo() 메서드에 접근하는 방법 확인해보기 - 단순히 인스턴스만을 통하는게 아니라 
		//											 클래스명으로 접근하고 객체 생성하여 접근해야한다
		//CompanyDAO의 getCompanyInfo()를 호출해서
		//companyInfo를 반환받아 콘솔에 출력해본다
		System.out.println(CompanyDAO.getInstance().getCompanyInfo());
	}
}
