package step1.unit.driver;
// step1.unit.test.TestClass 에서 로딩하는 클래스 
// static 은 클래스 로딩만 하면 메모리에 적재(실행)
// 객체 생성은 new 로 만들었는데 static은 객체 생성 없어도 로딩만 되면 실행 가능 
public class MyDriver {
	private static String dbName = "마이데이터베이스";
	static {//static initialize 클래스가 로딩되면 실행
		System.out.println(dbName + "연동을 위한 초기 작업");
	}
}
