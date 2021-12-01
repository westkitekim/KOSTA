package org.kosta.model;

import java.io.Serializable;

public class CustomerDTO implements Serializable{
	/**
	 * session으로 보내는 객체이므로 직렬화 필요(자동저장)
	 */
	private static final long serialVersionUID = -4942222445046444848L;
	private String id;
	private String name;
	private String address;
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

















