package org.kosta.springmvc02.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.springmvc02.model.dto.CustomerDTO;

//legacy든 boot든 
@Mapper
public interface CustomerMapper {
	public int getTotalCustomerCount();
	public CustomerDTO findCustomerById(String id);
	public void registerCustomer(CustomerDTO customerDTO);
}
