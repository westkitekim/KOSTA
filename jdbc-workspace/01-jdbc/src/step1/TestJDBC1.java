package step1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * java application 과 database 연동
 *   1. jdbc driver loading (jdk 1.6 버전 이상에서는 생략 가능, But 버전이 올라가면서 사용을 안 해도 되나 알고 있어야 한다 )
 *   2. db Connection - 
 *   3. PreparedStatement - (SQL에 실행시키기 위한 단계) sql이라는 말을 실행 
 *   4. ResultSet - 결과 반환받고
 *   5. close - 종료
 *   
 *   왜 JDBC를 사용하는가 ? - 다형성 , 하나의 소통방식으로 다향한 구현체들을 사용 (ex. play 재생버튼)
 *    인터페이스만으로 응용프로그램 개발자는 개발만 하도록 하고 jdbc의 인터페이스의 connection, Prepared등의 인터페이스를 implements하고 있다 
 *    장점 : 표준화 , sql의 상세한 부분들이 다를 순 있지만 프로그래밍 쪽은 변화가 없다 
 *    jdbc interface 만 보고 구현하기 때문에 생산성이 높아진다 
 *   
 *   Encapsulation 의 장점( 다시 복습 )     
 *    구현체가 업데이트 되어도 사용자에게는 영향이 없다 
 *    
 *    자바 응용프로그램 개발자
 *    언어를 만드는 측, 표준 제안하는 측 (jdbc) jdbc 명세(인터페이스)를 제공
 *    벤더사 (oracle.. )
 *    
 *   jdbc 사용하면 생산성과 유지보수성 향상
 *   
 */
public class TestJDBC1 {
	public static void main(String[] args) {
		//프린터 설치 하거나 usb를 새로 넣을 때 운영체제에서 자동으로 설치해주는 것과 같은 원리의 driver(예전엔 직접 설치)
		//스마트폰을 새로 구입하면 컴퓨터와 새로운 기기와의 연결을 가능하게 해주는 것이 driver 
		//연동위한 초기 정보 담기 ( jre의 ojdbc6.jar에 담김 )
		//메모리 상에 드라이버 올라감 
		//jre - ojdbc6.jar - oracle.jdbc - OracleDriver
		String driver = "oracle.jdbc.OracleDriver"; //패키지명.클래스명
		try {
			//oracle jdbc 드라이버 로딩(step.unit 패키지 참고)
			//1번만 이루어짐, 1.6이상부터 드라이버 로딩 생략 가능
			//스마트폰 새것을 컴에 연결할 때 드라이버 처음 한 번만 설치
			Class.forName(driver);//예외 발생 try/catch 처리, 클래스를 못 찾으면 예외발생
								  //Class.forName() -> (oracledriver) class 를 loading 시킨다 -> static 정보가 meta space에 저장
								  //자바와 연동하기 위한 db 툴들이 동일하게 자바에서 동작(자바 뿐만 아니라 다른 곳에서도 많이 사용됨)  
								  //객체 생성 없이 클래스 로딩만 한다 
								  //드라이버 클래스 로딩 목적 뿐만 아니라 class.forname refelction에서도 사용된다
			System.out.println("jdbc driver loading");//초기 설정을 oracle과 연동했기 때문에 모든 jre에 ojdbc6.jar있음
			
			//2. db connection
			//oracle database와 연결 -> db와 대화가능해진다 -> sql 실행 가능해진다 (db와 연결하면) 
			//강사님 디비에 접속
			//String url = "jdbc:oracle:thin:@221.150.136.4:1521:xe";//ip에 따라 같은 db 사용 가능
			//Connection은 사용자가 다를 수도 있기 때문에 연결될 때마다 작성
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			Connection con = DriverManager.getConnection(url, "scott", "tiger");//예외발생 가능, 오라클의 id와 password 작성
			System.out.println("oracle db와 connection : " + con);
			
			//3. PreparedStatement (준비된 진술, 보안상의 장점 해킹될 수 있기 때문에 ~? ) 
			//진술객체 생성 db에 진술할 객체 생성 
			//추가> PreparedStatement 의 역할 
			//	   1. 쿼리 문장 분석
			//	   2. 컴파일
			//     3. 실행 
			//	   => PreparedStatement는 처음에만 1~3단계 실행하고 캐시에 담아 재사용함
			
			//이전에 01-db-sql2에서 생성했던 member TABLE이다 
			String sql = "select id, password, name, address from member";
			PreparedStatement pstmt = con.prepareStatement(sql);
			//ResultSet : 결과의 집합이 넘어오는데, executeQuery의 반환 형식이 ResultSet이다 
			//rs에 결과의 집합(레코드 집합)이 담기는데, 서버에서는 결과의 집합을
			//클라이언트에게 모두 돌려주는 것이 아니라 한 개의 레코드씩 준다
			//결과 집합은 서버에 있음, 클라는 한 번에 받을 방법 없음
			
			//서버 쪽에서는 클라에게 한 레코드씩 돌려주기 위해 위치 확인을 위한 커서가 있다!
			//==> 레코드를 가라카가 위한 일종의 포인터 
			//커서를 사용하기 위한 도구로 ResultSet으로 반환되는 rs 사용
			//ResultSet 객체가 생성된다는 것은 결과 집합을 받은 것이 아니라 
			//이용할 수 있다는 것을 뜻한다
			
			//클라로 전달된 레코드를 담는 그릇이 ResultSet!  
			ResultSet rs = pstmt.executeQuery();// sql 실행, resultSet으로 반환
			//rs에 담긴 결
			//rs.next() : 다음꺼 주시오!! (패치)하면 
			//레코드의 앞머리(Before of File, BoF)를 가리키던 커서가 다음으로 움직임
			//이 구문을 호출해야만 클라에개 한 행이 전달된다
			
			//계속 레코드 돌다가 더이상 가져올 것이 없으면 그 상태의 위치는 End of File, EoF
			while(rs.next()) {// 조회 결과 행이 존재하면 true
				//getString index는 1부터 시작 , 행을 나타냄, getInt, getDouble 등이 있음 
				//rs.getString : column index 1에 해당하는 문자열을 주시오!!
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));//column index 1
				
			}
			rs.close();
			pstmt.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		
	}
}













