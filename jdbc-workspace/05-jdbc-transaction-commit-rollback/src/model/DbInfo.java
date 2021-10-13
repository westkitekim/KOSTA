package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface DbInfo {//interface는 private 사용 불가 , 상수 변수는 대문자
	String DRIVER = "oracle.jdbc.OracleDriver";
	String URL = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String USERNAME = "scott";
	String PASSWORD = "tiger";
}
