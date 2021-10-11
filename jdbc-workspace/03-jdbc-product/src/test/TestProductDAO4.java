package test;

import java.sql.SQLException;
import java.util.ArrayList;

import model.ProductDAO;

//상품들이 어떤 제조사에 의해 만들어졌는지 조회하는 예제(중복 제거)
public class TestProductDAO4 {
	public static void main(String[] args) {
		try {
			ProductDAO dao = new ProductDAO();
			//제네릭은 maker만 반환하므로 간단하게 string 
			ArrayList<String> list = dao.getMakerKindList();
			for(int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
