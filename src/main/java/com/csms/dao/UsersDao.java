package com.csms.dao;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

import com.csms.entity.Users;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface UsersDao extends CrudRepository<Users, Integer>{

	Users findByEmail(String email);
    
	Users findByName(String name);
	
	void deleteByEmail(String email);

}
