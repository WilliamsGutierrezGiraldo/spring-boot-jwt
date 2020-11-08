package com.mainsoft.test.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mainsoft.test.persistence.entities.ClienteEntity;

@Repository
public interface IClienteRepository extends CrudRepository<ClienteEntity, Long> {

}
