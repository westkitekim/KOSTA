package test.reflection;

class ReflectionService {
	public void create(String command) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		//현재 패키지명을 동적으로 받환받는다
		String packageInfo = this.getClass().getPackage().getName();
		System.out.println(packageInfo + "." + command);
		Player p = (Player)Class.forName(packageInfo + "." + command).newInstance();
		p.play();
	}
}
public class TestAutoCreateInstance2 {
	public static void main(String[] args) {
		String command = "CDPlayer";
		command = "Youtube";
		ReflectionService service = new ReflectionService();
		try {
			service.create(command);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
/*
 * 객체 생성시에 클래스 로딩이 되어야 되기 때문에 Class.forname() 으로 클래스 로딩 
 * 클래스가 추가될 때마다 추가하지 않고 자동적으로 생성이 가능하게 한다
 * 클래스로부터 객체생성하는 new 부분이 newInstance() -- 타입은 object
 */
