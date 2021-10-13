package test;

import java.sql.SQLException;

import model.CardDAO;
//Transaction의 필요성을 확인해보는 예제 
public class TestCardDAO1 {
	public static void main(String[] args) {
		try {
			CardDAO dao = new CardDAO();
			//정상적인 실행은 card와 point table에 각각 정보가 등록된다 
			dao.registerCardAndPointVer1("java", "아이유", "cgv", 10000);
			
			//고의로 예외적인 상황을 만들어서 테스트 해본다 
			//아래의 코드를 실행하면 card table에는 insert가 되고
			//point table에 insert 될 때 예외가 발생 
			//즉 카드는 등록(지급), 포인트는 등록(적립)되지 않아 트랜잭션 처리에 문제가 발생한 예이다 
			//카드는 지급됐으나 포인트가 적립이 되지 않은 상태 
			
			//원자성 : 더이상 이 작업은 쪼개질 수 없는 것(쪼개질 수 없는 작업단위) 
			//카드와 포인트는 한 몸이기 때문에 둘 중 하나라도 예외가 생기면 rollback해야 한다
			
			//카드 등록 ok 1 만 출력되고 포인트 지급시 문제 발생하게 된다 
			//포인트 타입을 지정해 주지 않아 예외가 발생한다 
			//예외가 나온다고 해도 최대한 대처를 해야한다 
			//시스템에 예외가 없을 순 없으나 이러한 상황은 안된다. 포인트 사기..
			//강하늘카드가 지급이 되면 안되는 경우!! 
			//db에서 point_type contraint를 not null 로 지정했기 때문에 에러발생
			dao.registerCardAndPointVer1("spring", "강하늘", null, 10000);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
