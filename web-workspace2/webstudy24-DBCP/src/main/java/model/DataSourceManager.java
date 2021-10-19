package model;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

/*
 * 	WAS ( Apache Tomcat ) 에서 제공하는 DBCP 객체를 생성해 공유하는 클래스
 * 	시스템 상에서 단 하나 존재하면 되므로 Singleton Design Pattern을 적용한다(커넥션 풀은 단 하나만 존재) 
 * 	
 * 	DBCP : Database Connection Pool
 * 		   시스템 성능 향상이 목적
 * 		   컨넥션을 생성하고 소멸하는 방식이 아니라 미리 컨넥션들을 생성해놓고 
 * 		   필요시 빌려주고 반납받는 형식으로 컨넥션을 운영한다
 * 
 * 	javax.sql.Datasource Interface : 
 * 		   WAS 및 오픈소스 진영에서 제공하는 다양한 DBCP 구현체들이 implements 하는 인터페이스
 * 		   실제 어플리케이션 측( 사용하는 측 ) 에서는 개별 DBCP 구현체들을 보고 사용하는 것이 아니라 
 * 		   DataSource Interface 의 abstract method를 이용해 개발하게 된다
 * 		   이후 DBCP 구현체가 변경되어도 이를 사용하는 어플리케이션 측에서는 영향이 최소화된다(Polymorphism, 결합도가 느슨해진다)(dbcp가 implements 하는게 DataSource이므로 dbcp가 DataSource라고 생각?)
 * 			
 * 		   getConnection() : 이전의 getConnection(url, username, password) 와 다르게 매개변수 없이 사용가능
 * 
 * 		   원리 : 커넥션 풀에 초기에 커넥션 객체 5개 만들어두고 client1이 오면 한 개씩 빌려가는데 0.0..n초대에 빌려갔다 반납한다. 그런데 그 시간안에 여러클라이언트가 동시에 들어올 때
 * 				 어떻게 해야하는가? (우주대폭팔 서버의 인기, 우다다 클라이언트 들어오기) - 동시접속수가 너무 많으면 만들어놓은 커넥션 다 빌려주고 나서 
 * 				 만들어놓은 커넥션 사이즈가 0이 되면, 이 때 스레드의 wait() notify() -- 오브젝트에 있는 메서드 , 서블릿의 스레드들이 자원이 바닥이 났다? -- 그럼 풀의 사이즈가 
 * 				 0이면 (if(pool.size() == 0) wait(500) - 0.5초 대기 짧은 웨이트 걸었다가 누가 반납할거기 때문에 그 때 notify()로 접속한다
 * 				 하지만 여전히 사이즈가 0 이면 max인 25개에서 빌려갈 수 있다는 것이다 - getConnection으로
 */
public class DataSourceManager {
	private static DataSourceManager instance = new DataSourceManager();
	//javax.sql.DataSource 로 import
	private DataSource dataSource;
	//커넥션풀을 생성하는 곳은 DataSourceManager() 메서드 내부에 구현한다
	private DataSourceManager() {
		//맨 처음 객체 생성
		//import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
		BasicDataSource dbcp = new BasicDataSource();
		dbcp.setDriverClassName("oracle.jdbc.OracleDriver");//드라이버로딩
		dbcp.setUrl("jdbc:oracle:thin:@127.0.01:1521:xe");
		dbcp.setUsername("scott");
		dbcp.setPassword("tiger");
		//서비스 환경에 알맞게 설정할 수 있다
		dbcp.setInitialSize(5);//처음 dbcp 생성시점에 Connection Pool에 connection 객체를 5개 생성해 놓는다 (숫자는 증감 가능)
		dbcp.setMaxTotal(25);//최대 connection 객체 25개까지
		this.dataSource = dbcp;//상위에서 불려올 수 있다..? 
	}
	public static DataSourceManager getInstance() {
		return instance;
	}
	public DataSource getDataSource() {
		return dataSource;
	}
}


























