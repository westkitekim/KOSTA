package step2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * MEMBER TABLE에 INSERT 하는 예제
 * 
 * JDBC 개발단계
 *   1. JDBC Driver loading
 *   2. Connection
 *   3. PreparedStatement -> insert sql 실행 메서드는 executeUpdate() 사용 (select 시에는 executeQuery() )
 *   4. close
 */
public class TestJDBC2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.OracleDriver";
		try {
			Class.forName(driver); //class를 로딩하는 애, 특정 클래스 로딩시킴
			System.out.println("oracle jdbc driver loading");
			//driverManager 반환형이 Connection
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "scott", "tiger");
			System.out.println("connection");
			String sql = "insert into member(id, password, name, address) values (?, ?, ?, ?)";//?는 그 부분만 따로 바인딩 시키겠다는 뜻
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "jsp");//1의 의미는 첫 번째 물음표(id) ?, id에 jsp를 할당
			pstmt.setString(2, "a");//2는 두번째 ?, password에 a를 할당
			pstmt.setString(3, "이효리");
			pstmt.setString(4, "애월읍");
		
			//sql 실행
			//한번 넣었는데 또 실행하면 에러난다 (PRIMARY KEY 제약조건 때문 - 동일한 id 인 jsp가 들어가므로) 
			int result = pstmt.executeUpdate();//sql 실행해서 테이블에 영향을 준 row의 수가 반환된다 (1명 넣어서 1이 반환)
			System.out.println("insert member" + result);
			pstmt.close();
			con.close();
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
