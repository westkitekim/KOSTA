package org.kosta.springmvc02.model.dto;

public class CustomerDTO {
	private String id;
	private String name;
	private String address;
	/*
	 * MyBatis Framework 를 사용해서 개발시에 
	 * 해당 클래스의 매개변수가 있는 생성자가 별도로 정의되어 있을 때는 
	 * 반드시 기본생성자(디폴트 생성자) 를 명시해야 한다 
	 */
	public CustomerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerDTO(String id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
		return "CustomerDTO [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
	
}
