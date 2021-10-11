package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// DAO : Data Access Object
public class ProductDAO {
	private String driver = "oracle.jdbc.OracleDriver";
	// ip와 port까지 포함하는 주소 db의 제품마다 url 형식과 port도 다름
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private String username = "scott";
	private String password = "tiger";

	public ProductDAO() throws ClassNotFoundException {
		Class.forName(driver);// checked Exception

	}
	//sql구문이 select가 아닌 insert/update/delete는  
	//ResultSet을 사용하지 않기 때문에 해당 함수를 사용한다 
	public void closeAll(PreparedStatement pstmt, Connection con) throws SQLException {
		if (pstmt != null) // 존재할 때만 닫아줌
			pstmt.close();
		if (con != null)
			con.close();
	}
	//select 일 경우 오버로딩한 closeAll 메서드 사용 
	public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection con) throws SQLException {
		if (rs != null)
			rs.close();
		closeAll(pstmt, con);// 위에서 선언한 함수 재사용
	}

	/*
	 * public int getProductTotalCount() throws SQLException { Connection con =
	 * null; PreparedStatement pstmt = null; ResultSet rs = null; int count = 0; try
	 * { con = DriverManager.getConnection(url, username, password); String sql =
	 * "select count(*) from product"; pstmt = con.prepareStatement(sql);
	 * 
	 * count = rs.getInt(1);
	 * 
	 * } finally {// 에러가 나도 실행됨 //항상 작업을 했으면 닫아줘야 하기 때문에 try/catch closeAll(rs,
	 * pstmt, con); }
	 * 
	 * return count; }
	 * 
	 */
	public int getProductTotalCount() throws SQLException {
		int totalCount = 0;// number 형을(db에서) int, string으로 받아올 수도 있다
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;// resultset은 반드시 next해야 다음 셀로 이동 (columns에 있다고 생각하자)

		try {
			con = DriverManager.getConnection(url, username, password);
			String sql = "select count(*) from product";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();// sql 특성상 무조건 나오게 되어있는데
			if (rs.next())// 조회된 결과가 있으면 true를 반환하고
							// 결과행으로 cursor를 이동(한번만 이동)
				// getInt()의 column index??
				// getString() 과 조회할 데이터를 가지고 올 때 어떤 데이터를 가지고 올 것인가
				// 조회된 결과값 테이블을 참조하는 것이기 때문에 (해당하는 sql결과값 참조)
				// index는 당연히 1이어야 한다
				// 이해가지 않으면 select count(*) from product 를 실행해본다
				totalCount = rs.getInt(1);
				//rs.next()는 두 가지 값이므로 
				//int totalCount = 0;으로 먼저 초기화해주면 
				//else를 작성하지 않아도 된다
				//1이 아니면 else를 작성하지 않아도 초기화 된 값인 0이 되기 때문

		} finally {// 에러가 나도 실행됨, 항상 작업을 했으면 닫아줘야 하기 때문에 try/catch
			closeAll(rs, pstmt, con);
		}

		return totalCount;
	}
	/*
	 * public boolean existsById(int productId) throws SQLException { boolean
	 * message = false; Connection con = null; PreparedStatement pstmt = null;
	 * ResultSet rs = null;//resultset은 반드시 next해야 다음 셀로 이동 (columns에 있다고 생각하자)
	 * 
	 * try { con = DriverManager.getConnection(url, username, password); String sql
	 * = "select id from product where id = ?"; pstmt = con.prepareStatement(sql);
	 * pstmt.setString(productId, sql); rs = pstmt.executeQuery();
	 * 
	 * rs.next(); if(rs.getInt(1) == 1) message = true; else message = false;
	 * 
	 * } finally { closeAll(rs, pstmt, con); }
	 * 
	 * return message; }
	 */

	public boolean existsById(int productId) throws SQLException {
		boolean result = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;// resultset은 반드시 next해야 다음 셀로 이동 (columns에 있다고 생각하자)

		try {
			con = DriverManager.getConnection(url, username, password);
			String sql = "select count(*) from product where id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, productId);//첫 번째 ? 대해 할당
			rs = pstmt.executeQuery();
			//풀이 1
			/*
			if (rs.next() && rs.getInt(1) == 1)
				result = true;
			*/
			
			//풀이 2
			//현재 커서위치(속성 가리킴)에서 다음 행이 있다면, 즉 가져올 데이터가 하나라도 있다면
			if(rs.next()) {//데이터 첫 행이 있다면
				//데이터 첫 행의 첫 열을 가져오는건데, 왜 1일까?
				//.sql파일 참고, primary key인 id가 있는지 없는지 검색하는 것이기 때문에 
				//1 or 0 반환 1이면 존재 
				//id 의 ? 조건에 맞는 것은 오직 1개만 있으므로 
				if(rs.getInt(1) == 1) {//id 데이터 값이 반환되는 것이 아니라 
									   //count에 의해 1 or 0이 반환된다 
					result = true;
				}
			}
		} finally {
			closeAll(rs, pstmt, con);
		}

		return result;
	}
	/*
	 * product table 에 product 정보를 insert하는 메서드 
	 */
	/*
	public void register(ProductDTO dto) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(url, username, password);
			String sql = "insert into product(id, name, maker, price) values (?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getId());// 물음표에 차례로 바인딩
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getMaker());
			pstmt.setInt(4, dto.getPrice());
			
			pstmt.executeUpdate();
			
		} finally {// 에러가 나도 실행됨 //항상 작업을 했으면 닫아줘야 하기 때문에 try/catch
			closeAll(pstmt, con);
	}
	}
	*/
	
	//1. try / finally 구조 
	//2. 목표는 close 입출력을 받아야 하기 때문 
	//자원 반납을 잘 하도록 만든다 -지역변수 밖에서 con, pstmt 선언
	public void register(ProductDTO dto) throws SQLException {
		//김서연씨는 처음에 productDTO 객체를 또 생성해서 null값이 나와쩌용 잘해브럿어
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(url, username, password);
			//sql 문에서 전체에 넣을 때는 (id, name, maker, price) 생략은 가능하나,
			//가독성을 위해 column을 모두 명시하도록 합시다 
			String sql = "insert into product(id, name, maker, price) values (?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			//그러니까.. setString(index, )은
			//두번 째 인자값을 sql구문의 index번째 물음표에 넣겠다는 것이다 
			//물음표가 있는 sql 구문을 실행하면 정상 수행이 안되므로 
			//?를 채워줘야 하기 때문에 setString을 통해서 넣어준다 or setInt()
			pstmt.setString(1, dto.getId());// 첫 번째 물음표부터 차례로 바인딩 1번째는 id에 할당
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getMaker());
			pstmt.setInt(4, dto.getPrice());
			
			pstmt.executeUpdate();//영향을 미친 행의 개수 반환 
			
		} finally {// 에러가 나도 실행됨 //항상 작업을 했으면 닫아줘야 하기 때문에 try/catch
			closeAll(pstmt, con);
	}
		
	}
	
	/* < 내 풀이 >
	public ArrayList<String> getMakerKindList() throws SQLException {
		String maker = null;
		
		ArrayList<String> list = new ArrayList<String>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(url, username, password);
			String sql = "select distinct maker from product";// id는 어차피 가지고 오니까 생략
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();// 0일 수 있고 여러명있을 수 있음

			// 검색한 행이 존재하면 true 반환
			while (rs.next()) {// 3개의 값이 있다면 3번 true 나옴 커서로 움직이기 때문에 반드시 실행되어야함
				// 방법1
				// list.add(new MemberVO(rs.getString(1),null,rs.getString(2),null));
				// 방법2 set method 이용
				maker = rs.getString(1);
				list.add(maker);
				// 방법3 생성자 오버로딩 추가

			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}
	*/
	
	/*
	 * maker의 종류를 조회하여 리스트로 반환하는 메서드 
	 */
	public ArrayList<String> getMakerKindList() throws SQLException {
		//String maker = null;
		ArrayList<String> list = new ArrayList<String>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;//select이기 때문에 ResultSet 사용 
		//위의 지역변수들을 올려주는 이유는 finally 구문에서 재사용하여 
		//close()메서드를 사용하기 때문에 미리 초기화해준다
		//try block에서 초기화시 finally에서 사용 불가능 - local variable

		try {
			con = DriverManager.getConnection(url, username, password);
			//sql 구문을 미리 sql 파일에서 실행하여 확인한 다음 코드 작성하는게 좋음
			String sql = "select distinct maker from product";// id는 어차피 가지고 오니까 생략
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();// 0일 수 있고 row가 여러 개 있을 수 있기 때문에 
									  //while문을 통해서 end까지 갈때까지 반복

			// 검색한 행이 존재하면 true 반환
			while (rs.next()) {// 3개의 값이 있다면 3번 true 나옴 커서로 움직이기 때문에 반드시 실행되어야함
				// 방법1
				list.add(rs.getString(1));
				// 방법2 set method 이용
				//maker = rs.getString(1);
				//list.add(maker);
				// 방법3 생성자 오버로딩 추가
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}
/*
	public ArrayList<ProductDTO> findProductListByPriceOrderByPriceDesc(int lowPrice, int highPrice) throws SQLException {
			ArrayList<ProductDTO> list = new ArrayList<ProductDTO>();
			
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = DriverManager.getConnection(url, username, password);
				//sql 구문을 미리 sql 파일에서 실행하여 확인한 다음 코드 작성하는게 좋음
				String sql = "select name from product where price between ? and ? order by price desc";// id는 어차피 가지고 오니까 생략
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, lowPrice);
				pstmt.setInt(2, highPrice);
				rs = pstmt.executeQuery();// 0일 수 있고 여러명있을 수 있기 때문에 
										  //while문을 통해서 end까지 갈때까지 반복

				while(rs.next()) {
					ProductDTO dto = new ProductDTO();
					dto.setName(rs.getString(1));
					list.add(dto);
				}
				
			} finally {
				closeAll(rs, pstmt, con);
			}
			return list;
	
	}
	*/
	
	
	public ArrayList<ProductDTO> findProductListByPriceOrderByPriceDesc(int lowPrice, int highPrice) throws SQLException {
		ArrayList<ProductDTO> list = new ArrayList<ProductDTO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, username, password);
			//sql 구문을 미리 sql 파일에서 실행하여 확인한 다음 코드 작성하는게 좋음
			//sql이 길면 여러 문장이 나와야 하는데, 많은 사용자가 필요로 한다면 String을 연결하여 사용가능 
			//sql이 변화되면서 문자열이 만들어지기 때문에 부담이 적다
			//sql 구문이 길면 StringBuilder를 사용하여 부담을 덜어주는 것이 부담을 줄이는 좋은 방법
			StringBuilder sql = new StringBuilder();
			sql.append("select id, name, maker, price ");//뒤에 공백에 유의
			sql.append("from product ");
			sql.append("where price >= ? and price <= ? ");
			sql.append("order by price desc");
			// id는 어차피 가지고 오니까 생략
			//toString()으로 문자열로 변경(StringBuilder를 String으로 만든다)
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, lowPrice);
			pstmt.setInt(2, highPrice);
			rs = pstmt.executeQuery();// 0일 수 있고 여러명있을 수 있기 때문에 
									  //while문을 통해서 end까지 갈때까지 반복

			// 검색한 행이 존재하면 true 반환
			while (rs.next()) {// 3개의 값이 있다면 3번 true 나옴 커서로 움직이기 때문에 반드시 실행되어야함
				list.add(new ProductDTO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4)));
			
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return list;

}

	
}
