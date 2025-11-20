package com.csms.dao;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.csms.entity.Sites;
import com.csms.entity.Users;

@Repository
@EnableJpaRepositories
public interface SitesDao extends CrudRepository<Sites, Integer>{

}
