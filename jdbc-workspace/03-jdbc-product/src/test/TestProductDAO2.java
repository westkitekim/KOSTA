package test;

import java.sql.SQLException;

import model.ProductDAO;
//존재하는 id test
//특정 id가 존재하는지 조회해보는 예제 
public class TestProductDAO2 {
	public static void main(String[] args) {
		try {//priamary key이므로 존재하거나 존재하지 않거나 2가지 경우의 수만 있음  
			ProductDAO dao = new ProductDAO();
			int productId = 1;//존재하는 아이디 test
			productId = 7;
			boolean result = dao.existsById(productId);
			if(result)
				System.out.println(productId + " 아이디 상품이 존재합니다");
			else
				System.out.println(productId + " 아이디 상품이 존재하지 않습니다");
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
