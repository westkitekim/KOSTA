package test;

import java.sql.SQLException;

import model.GuestBookDAO;
import model.GuestBookDTO;

public class TestGuestBookDAO1 {
	public static void main(String[] args) {
		//1. guestbook 에 insert ( guestbook_no 는 sequence로 자동발급 )
		try {
			GuestBookDAO dao = new GuestBookDAO();
			GuestBookDTO dto = new GuestBookDTO("즐월요일", "즐공하자");
			System.out.println("글등록이전 dto" + dto);
			
			dao.register(dto);
			System.out.println("방명록에 글등록");
			//여전히 guestbookNo는 0이고, 글등록 후에는 db에서 발급한 sequence 즉, 방명록 글번호를 확인하고자 할 때는 
			//TestGuestBookDAO3 의 시퀀스.currval을 이용하면 된다 
			//등록 즉시 내 글번호는 받기 위한 방법
			System.out.println("글등록이후 dto" + dto);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}
