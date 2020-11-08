package com.mainsoft.test.service;

import org.springframework.stereotype.Service;

import com.mainsoft.test.dto.ProductoDto;
import com.mainsoft.test.util.Response;

@Service
public interface ProductoService {
	
	public Response save(ProductoDto dto);
	
	public Response update(ProductoDto dto);
	
	public Response deleteById(Long id);
	
	public Response fetchById(Long id);
	
	public Response fetchAll();

}
