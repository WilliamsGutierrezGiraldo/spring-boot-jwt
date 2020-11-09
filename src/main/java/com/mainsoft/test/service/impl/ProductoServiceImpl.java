package com.mainsoft.test.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.mainsoft.test.dto.ProductoDto;
import com.mainsoft.test.persistence.entities.ProductoEntity;
import com.mainsoft.test.persistence.repository.IProductoEntity;
import com.mainsoft.test.service.ProductoService;
import com.mainsoft.test.util.Response;
import com.mainsoft.test.util.ResponseStatusEnum;

@Service
public class ProductoServiceImpl implements ProductoService {
	
	@Autowired
	IProductoEntity repository;

	@Override
	public Response save(ProductoDto dto) {
		Response response = new Response();
		ProductoEntity entity = new ProductoEntity();
		entity.setNombre(dto.getNombre());
		entity.setPrecio(dto.getPrecio());
		try {
			response = new Response(ResponseStatusEnum.SUCCESS);
			response.setDataPair("producto almacenado exitosamente, id: ", repository.save(entity).getId());
		} catch (IllegalArgumentException e) {
			response = new Response(ResponseStatusEnum.BAD_REQUEST);
		}
		
		return response;
	}

	@Override
	public Response update(ProductoDto dto) {
		Response response = new Response();
		Optional<ProductoEntity> entity = repository.findById(dto.getId());
		if (entity.isPresent()) {
			entity.get().setNombre(dto.getNombre());
			entity.get().setPrecio(dto.getPrecio());
			try {
				response = new Response(ResponseStatusEnum.SUCCESS);
				response.setDataPair("producto actualizado exitosamente, id: ", repository.save(entity.get()).getId());
			} catch (IllegalArgumentException e) {
				response = new Response(ResponseStatusEnum.BAD_REQUEST);
			}
		} else {
			response = new Response(ResponseStatusEnum.NOT_DATA_FOUND);
		}
		
		return response;
	}

	@Override
	public Response deleteById(Long id) {
		Response response = new Response();
		Optional<ProductoEntity> entity = repository.findById(id);
		if (entity.isPresent()) {
			repository.delete(entity.get());
			response = new Response(ResponseStatusEnum.SUCCESS);
			response.setDataPair("producto eliminado, id: ", entity.get().getId());
		} else {
			response = new Response(ResponseStatusEnum.NOT_DATA_FOUND);
		}
		
		return response;
	}

	@Override
	public Response fetchById(Long id) {
		Response response = new Response();
		Optional<ProductoEntity> entity = repository.findById(id);
		if (entity.isPresent()) {
			response = new Response(ResponseStatusEnum.SUCCESS);
			response.setDataPair("producto", entity.get());
		} else {
			response = new Response(ResponseStatusEnum.NOT_DATA_FOUND);
		}
		
		return response;
	}

	@Override
	public Response fetchAll() {
		Response response = new Response();
		List<ProductoEntity> entidades = (List<ProductoEntity>) repository.findAll();
		List<ProductoDto> productos = null;
		if (!CollectionUtils.isEmpty(entidades)) {
			productos = new ArrayList<>();
			for (ProductoEntity productoEntity : entidades) {
				ProductoDto dto = new ProductoDto();
				dto.setId(productoEntity.getId());
				dto.setNombre(productoEntity.getNombre());
				dto.setPrecio(productoEntity.getPrecio());
				productos.add(dto);
			}
			response = new Response(ResponseStatusEnum.SUCCESS);
			response.setDataPair("productos", productos);
		} else {
			response = new Response(ResponseStatusEnum.NOT_DATA_FOUND);
		}
		
		return response;
	}

}
