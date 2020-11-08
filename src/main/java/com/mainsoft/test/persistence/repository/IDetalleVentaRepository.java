package com.mainsoft.test.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mainsoft.test.persistence.entities.DetalleVentaEntity;

@Repository
public interface IDetalleVentaRepository extends CrudRepository<DetalleVentaEntity, Long> {

}
