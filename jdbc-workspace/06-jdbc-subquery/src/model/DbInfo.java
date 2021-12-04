package model;

public interface DbInfo {
	//인터페이스이므로 아래 field 는 public static final로 인식된다
	//(static final 상수) 인터페이스명.상수명 으로 접근
	
	//한 프로젝트가 한 세계라고 생각 
	//jar 은 클래스들의 압축파일 
	//그 안에 jdbc가 implements 한 클래스들이 모여있음 
	String DRIVER = "oracle.jdbc.OracleDriver";
	//채팅 클라이언트가 서버에 접속했듯이 포트로 접속 (connection)
	String URL = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String USERNAME = "scott";
	String PASSWORD = "tiger";
	
	
	
}
