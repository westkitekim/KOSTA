package test;

import java.sql.SQLException;
import java.util.ArrayList;

import model.GuestBookDAO;
import model.GuestBookDTO;

public class TestGuestBookDAO2 {
	public static void main(String[] args) {
		//1. guestbook 에 insert ( guestbook_no 는 sequence로 자동발급 )
		try {
			GuestBookDAO dao = new GuestBookDAO();
			//2. 최근 글부터 출력되도록 조회한다(=guestbook_no 내림차순) 
			ArrayList<GuestBookDTO> list = dao.getAllGuestBookList();
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
