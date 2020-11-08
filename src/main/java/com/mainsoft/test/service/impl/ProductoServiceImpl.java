package com.mainsoft.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mainsoft.test.dto.ProductoDto;
import com.mainsoft.test.persistence.repository.IProductoEntity;
import com.mainsoft.test.service.ProductoService;
import com.mainsoft.test.util.Response;

@Service
public class ProductoServiceImpl implements ProductoService {
	
	@Autowired
	IProductoEntity repository;

	@Override
	public Response save(ProductoDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response update(ProductoDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response deleteById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response fetchById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response fetchAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
