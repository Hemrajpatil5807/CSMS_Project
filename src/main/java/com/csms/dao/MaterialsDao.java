package com.csms.dao;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.csms.entity.Materials;

@Repository
@EnableJpaRepositories
public interface MaterialsDao extends CrudRepository<Materials, Integer>{

}
