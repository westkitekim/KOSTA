package test.pattern;
/*
 * singleton design pattern 
 * 
 * 현 시스템에서는 CompanyDAO 객체는 한 번 생성하여 공유해 사용하면 되는 구조
 * --> Singleton Design Pattern을 적용해 외부에서 객체 생성하는 것을 막고 
 * 	   자신의 클래스에서 단 한번 객체를 생성해서 외부로 공유해서 사용하게 한다 
 * (singleton하면 다 좋은 것은 아님! -- 필요시에만 사용)
 */
public class CompanyDAO {
	//static 변수로 단 한번 객체 생성 (meta space에 현 객체 주소값을 저장)
	private static CompanyDAO instance = new CompanyDAO();
	private String companyInfo = "회사정보";
	//private 접근제어자로 외부에서 객체 생성하는 것을 막는다
	private CompanyDAO() {
		System.out.println("CompanyDAO 객체 생성");
	}
	//public static 메서드로 외부에 공유
	public static CompanyDAO getInstance() {
		return instance;
	}
	//Business Logic
	public String getCompanyInfo() {
		return companyInfo;
	}
}
