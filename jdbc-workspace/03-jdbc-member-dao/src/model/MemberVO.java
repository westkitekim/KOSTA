package model;
/*
 * VO : Value Object (값을 저장하는 객체, DTO로도 사용)
 * DTO : Data Transfer Object(전송하고도 싶으면 DTO) 
 * db 속성이 vo, dto 일치
 */
public class MemberVO {
	private String id;
	private String password;
	private String name;
	private String address;
	//기본 생성자를 따로 만드는 이유 : 생성자를 명시하면 
	// id 와 name 만으로 생성하고 싶을 때도 있기 때문 
	// 명시적 생성자를 만들면 
	public MemberVO() {//기본생성자 따로 생성
		super();
		
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
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", password=" + password + ", name=" + name + ", address=" + address + "]";
	}
	
	
}
