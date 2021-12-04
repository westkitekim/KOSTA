package test.json;

import java.util.ArrayList;

import org.json.JSONArray;

import model.CarDTO;

public class TestJSON2 {
	public static void main(String[] args) {
		ArrayList<String> list=new ArrayList<String>();
		list.add("황의조");
		list.add("손흥민");
		list.add("기성용");
		JSONArray ja1=new JSONArray(list);
		System.out.println(ja1.toString());
		ArrayList<CarDTO> carList=new ArrayList<CarDTO>();
		carList.add(new CarDTO("k5",100));
		carList.add(new CarDTO("sm6",200));
		JSONArray ja2=new JSONArray(carList);
		System.out.println(ja2.toString());
	}
}













