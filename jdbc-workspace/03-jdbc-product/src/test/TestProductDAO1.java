package test;

import java.sql.SQLException;

import model.ProductDAO;

public class TestProductDAO1 {
	public static void main(String[] args) {
		//총 상품 수 조회 (좋은 습관 : sql 먼저 만들어보고 DAO에 반영)
		try {
			ProductDAO dao = new ProductDAO();
			// hint : ResultSet 의 getInt(column Index) 를 이용한다
			int totalCount = dao.getProductTotalCount();
			System.out.println("총 상품 수:" + totalCount);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}
