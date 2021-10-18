package org.kosta.webstudy21.model;
//Singleton Design Pattern : 시스템 상에 단 한번 객체를 생성해 공유하여 사용하고자 할 때 적용하는 디자인 패턴
public class MockDAO {
	private static MockDAO instance = new MockDAO();
	private MockDAO() {}
	public static MockDAO getInstance() {
		return instance;
	}
	public String findProductById(String id) {
		String productInfo = null;
		if(id.equals("1"))
			productInfo = id + "새우깡 농심";
		return productInfo;
	}
	public void registerProduct(String productInfo) {
		System.out.println(productInfo + " 상품정보등록");
		
	}
}
