package com.csms.dao;

import org.springframework.data.repository.CrudRepository;

import com.csms.entity.Users;

public interface UsersDao extends CrudRepository<Users, Integer>{

	Users findByEmail(String email);
    
	Users findByName(String name);
	
	void deleteByEmail(String email);

}
