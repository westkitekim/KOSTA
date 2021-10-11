package model;

//import java.io.Serializable;
/*
 * implements Serializable 하는 이유 : 세션에 저장되는 MemberVO 객체가 서버 reload or stop 시에 직렬화되어 저장되기 위해 객체직렬화를 한다 
 * 수정하는 과정에서 memberVO 는 HttpServlet imple 한게 아니므로 
 * 리로드와 서버 닫고 서버 올리는 과정이 
 * 세션이 서버를 정지시킬때는 잘 저장하는데 업데이트해서 reloadable 되면 외부의 객체는 연결이 해제 된다 - > 해결하기 위해 객체직렬화 
 */
public class MemberVO{
	//private static final long serialVersionUID = 2379128892442727379L;
	private String id;
	private String password;
	private String name;
	private String address;
	public MemberVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MemberVO(String id, String password, String name, String address) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.address = address;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
