package org.kosta.model;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

/*
 *  Database Connection Pool 객체를 생성해 공유하는 클래스 
 *  DBCP -> 시스템 성능 향상을 위해 DB 컨넥션을 생성, 소멸시키지 않고
 *  		   미리 생성한 컨넥션을 빌려주고 반납하도록 한다. 
 *  javax.sql.DataSource Interface 타입으로 dbcp를 관리한다 
 *  이유는 WAS 가 변경되면 DBCP도 변경될 수 있으므로 추상화된 인터페이스 타입으로
 *  관리하는 것이 유지보수에 유리하다 
 */
public class DataSourceManager {
	private static DataSourceManager instance=new DataSourceManager();
	private DataSource dataSource;
	private DataSourceManager() {
		// was tomcat에서 제공하는 dbcp를 생성해서 사용한다 
		BasicDataSource dbcp=new BasicDataSource();
		dbcp.setDriverClassName("oracle.jdbc.OracleDriver");
		dbcp.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
		dbcp.setUsername("scott");
		dbcp.setPassword("tiger");
		dbcp.setInitialSize(3);//처음 로드될 때 생성해 놓을 컨넥션 수 
		dbcp.setMaxTotal(10);//최대 컨넥션 수 : 기본은 8 
		this.dataSource=dbcp;
	}
	public static DataSourceManager getInstance() {
		return instance;
	}
	public DataSource getDataSource() {
		return dataSource;
	}
}















