package test.reflection;

interface Player {
	public void play();
}

class CDPlayer implements Player {
	@Override
	public void play() {
		System.out.println("cd를 재생하다");
	}
}

class Youtube implements Player {
	@Override
	public void play() {
		System.out.println("동영상을 재생하다");
	}
}
//Class.forname(String className) : 클래스 정보가 로드, ( 객체 생성은 클래스 로딩이 되고 나서 가능 )
public class TestAutoCreateInstance {
	public static void main(String[] args) {
		String info = "test.reflection.CDPlayer";
		String info2 = "test.reflection.Youtube";
		try {
			//System.out.println(Class.forName(info).newInstance());;// return 클래스 객체 : Class.forName(), newInstance() : 객체생성
			//System.out.println(Class.forName(info2).newInstance());
			Player p1 = (Player)Class.forName(info).newInstance();//level을 인터페이스까지 다운캐스팅
			p1.play();
			Player p2 = (Player)Class.forName(info2).newInstance();
			p2.play();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
