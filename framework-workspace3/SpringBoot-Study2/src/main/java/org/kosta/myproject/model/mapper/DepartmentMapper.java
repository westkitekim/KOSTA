package org.kosta.myproject.model.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DepartmentMapper {
	
	int getTotalDepartmentCount();
	
}
