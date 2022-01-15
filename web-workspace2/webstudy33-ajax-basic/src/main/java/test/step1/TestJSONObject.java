package test.step1;

import org.json.JSONObject;

import model.CarDTO;
//key, value map 처럼 사용 
public class TestJSONObject {
	public static void main(String[] args) {
		//DTO 또는 VO를 JSONObject로 생성 
		CarDTO dto = new CarDTO("k5", 2000, "기아");
		JSONObject json = new JSONObject(dto);
		System.out.println(json.toString());
		
		JSONObject json2 = new JSONObject();
		json2.put("id", "javaking");
		json2.put("name", "아이유");
		System.out.println(json2.toString());
	}
}
