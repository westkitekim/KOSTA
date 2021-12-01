package org.kosta.model;

public class CarDTO {
	private String model;
	private int price;
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "CarDTO [model=" + model + ", price=" + price + "]";
	}
	
}







