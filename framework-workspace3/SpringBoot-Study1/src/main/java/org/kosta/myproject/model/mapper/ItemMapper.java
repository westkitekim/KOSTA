package org.kosta.myproject.model.mapper;//디렉토리 복사하여 resource아래에 패키지 생성

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ItemMapper {

	int getTotalItemCount();
	
}
