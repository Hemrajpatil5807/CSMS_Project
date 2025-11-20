package com.csms.service;

import java.util.List;

import com.csms.dto.UserReqDto;
import com.csms.entity.Users;

public interface UsersService {

	boolean register(UserReqDto ur);

	List<Users> getAllUsers();

	boolean updateUser(Users user);

	boolean deleteUser(String email);

	Users getUser(int id);

}
