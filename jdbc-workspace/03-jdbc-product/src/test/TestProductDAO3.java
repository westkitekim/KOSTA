package test;

import java.sql.SQLException;

import model.ProductDAO;
import model.ProductDTO;

// 상품정보를 등록하는 예제 (INSERT)
public class TestProductDAO3 {
	public static void main(String[] args) {
		try {
			ProductDAO dao = new ProductDAO();
			ProductDTO dto = new ProductDTO("5", "카스", "OB", 1700);
			//id 가 primary key 
			//DTO class에서는 id가 String타입으로 정의되어 있고,
			//existById()메서드에는 인자값의 타입이 int라서 숫자로 변환한다
			//primary key 인 id값으로 조회하기 때문에 경우의 수는 2가지, 
			//고로 DAO에서 boolean으로 체크한다 
			if(dao.existsById(Integer.parseInt(dto.getId()))) {
				System.out.println("상품이 존재하여 등록불가");
			}else {
				dao.register(dto);
				System.out.println("상품등록");
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
