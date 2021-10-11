package org.kosta.webstudy18.model;

import java.io.Serializable;
//세션으로 보내야 하기 때문에 객체 직렬화 
public class MemberVO implements Serializable{
	/**
	 * WAS 가 리로드 될 때 객체 직렬화를 통해 세션 정보를 유지하므로 
	 * 인증정보인 회원 클래스를 Serailizable interface 계층구조 하에 둔다
	 */
	private static final long serialVersionUID = 7439873340367491160L;
	private String id;
	private String password;
	private String name;
	private String address;
	public MemberVO() {
		super();
	}
	
	public MemberVO(String id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
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
