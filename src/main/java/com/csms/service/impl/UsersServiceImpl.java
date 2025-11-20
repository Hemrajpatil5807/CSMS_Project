package com.csms.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.csms.service.UsersService;
import com.csms.dao.UsersDao;
import com.csms.dto.UserReqDto;
import com.csms.entity.Users;

@Service
public class UsersServiceImpl implements UsersService{

	@Autowired
	UsersDao usersDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

	@Override
	public boolean register(UserReqDto urdto) {
		
		Users user = new Users(urdto.getName(), urdto.getEmail(), urdto.getPassword(), urdto.getRole());
		
        user.setPassword(passwordEncoder.encode(user.getPassword()));

		Users u = usersDao.save(user);
		
		if (u != null)
			return true;
		else
			return false;
	}
	
	@Override
	public Users getUser(int id) {
		
		Optional <Users> os = usersDao.findById(id);
		
		if(os.isPresent()) {
			Users u = os.get();
			return u;
	     }else {
			return null;
		  }
	}

	@Override
	public List<Users> getAllUsers() {
		
		List<Users> users = (List<Users>) usersDao.findAll();
		
		if (users != null)
			return users;
		else
			return null;
	}

	@Override
	public boolean updateUser(Users user) {
		
	  Users u = usersDao.findByEmail(user.getEmail());
	  
	  if(u != null) { 
		  u.setName(user.getName());
		  u.setEmail(user.getEmail());
		  u.setPassword(user.getPassword());
		  u.setRole(user.getRole());
		 if( usersDao.save(u) != null);
		    return true;
	  }
	  return false;
	}

	@Override
	public boolean deleteUser(String email) {
		
		usersDao.deleteByEmail(email);
		Users ou = usersDao.findByEmail(email);
		if (ou != null)
			return false;
		else
			return true;
		
	}
	
	
}
