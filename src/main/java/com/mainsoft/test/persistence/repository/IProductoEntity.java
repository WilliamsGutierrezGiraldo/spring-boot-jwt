package com.mainsoft.test.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mainsoft.test.persistence.entities.ProductoEntity;

@Repository
public interface IProductoEntity extends CrudRepository<ProductoEntity, Long> {

}
