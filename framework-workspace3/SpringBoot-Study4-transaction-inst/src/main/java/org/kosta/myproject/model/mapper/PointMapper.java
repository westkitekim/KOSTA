package org.kosta.myproject.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.myproject.model.domain.PointVO;
@Mapper
public interface PointMapper {
	public PointVO findPointById(String id);
	public void registerPoint(PointVO pointVO);
}
