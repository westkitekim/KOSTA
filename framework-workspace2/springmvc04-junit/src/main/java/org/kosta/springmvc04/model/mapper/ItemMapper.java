package org.kosta.springmvc04.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.springmvc04.model.domain.ItemDTO;

@Mapper
public interface ItemMapper {

	int getTotalItemCount();

	ItemDTO findItemByNo(int itemNo);

	List<ItemDTO> getAllItemList();

	void registerItem(ItemDTO itemDTO);

	
	
}
