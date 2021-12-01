package org.kosta.model;

public class UserDTO {
	private String id;
	private String name;
	private CarDTO carDTO;
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
	public CarDTO getCarDTO() {
		return carDTO;
	}
	public void setCarDTO(CarDTO carDTO) {
		this.carDTO = carDTO;
	}
	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", name=" + name + ", carDTO=" + carDTO + "]";
	}
	
}
