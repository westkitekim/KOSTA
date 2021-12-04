package test.json;

import org.json.JSONObject;

import model.CarDTO;

public class TestJSON1 {
	public static void main(String[] args) {
		JSONObject json1=new JSONObject();
		json1.put("model", "소나타");
		json1.put("price", 200);
		System.out.println(json1.toString());
		CarDTO car=new CarDTO("K5",300);
		JSONObject json2=new JSONObject(car);
		System.out.println(json2.toString());
	}
}
















