package org.kosta.myproject;

import org.junit.jupiter.api.Test;
import org.kosta.myproject.model.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootStudy1ApplicationTests {
	@Autowired
	private ItemMapper itemMapper;
	
	@Test
	void contextLoads() {
		int count = itemMapper.getTotalItemCount();
		System.out.println("상품 수: " + count);
	}
}
