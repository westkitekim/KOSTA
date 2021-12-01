package org.kosta.springmvc04.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kosta.springmvc04.model.domain.ItemDTO;
import org.kosta.springmvc04.model.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//JUnit test
//java 단위테스트(jUnit)를 위한 어노테이션
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring-model.xml"})//해당 설정파일을 로드함
public class ItemUnitTest {
	@Autowired
	private ItemMapper itemMapper;
	
	@Test
	public void getTotalItemCount() {
		System.out.println(itemMapper.getTotalItemCount());
	}
	
	@Test
	public void findItemByNo() {
		int itemNo = 1;
		ItemDTO item = itemMapper.findItemByNo(itemNo);
		System.out.println(item);
	}
	
	@Test
	public void getAllItemList() {
		List<ItemDTO> list = itemMapper.getAllItemList();//java.util.List
		for(ItemDTO dto : list) {
			System.out.println(dto);
		}
	}
	
	@Test
	public void registerItem() {
		ItemDTO itemDTO = new ItemDTO("맥스", "오비", 1510);//생성자 이용 or 세터
		System.out.println("등록 전:" + itemDTO);
		itemMapper.registerItem(itemDTO);
		System.out.println("등록 후:" + itemDTO);
	}
}

























