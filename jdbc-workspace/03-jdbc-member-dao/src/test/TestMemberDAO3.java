package test;

import java.sql.SQLException;
import java.util.ArrayList;

import model.MemberDAO;
import model.MemberVO;
/*
 * member table에 저장된 회원 정보(id, name)를 list로 반환하는 메서드 list의 요소는 MemberVO이고
 * MemberVO 객체의 id와 name 인스턴스 변수의 정보만 할당되면 된다
 */
public class TestMemberDAO3 {
	public static void main(String[] args) {
		try {
			MemberDAO dao = new MemberDAO();
			
			ArrayList<MemberVO> list = dao.getAllMemberList();
			//for구문은 예외가 발생하면 멈춰야하기 때문에 add catch
			for(int i = 0; i < list.size(); i++) {
				System.out.println("id:" + list.get(i).getId() + 
								   " name:" + list.get(i).getName());
				
				
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
