package com.tap.dao;


import java.util.List;

import com.tap.model.User;

public interface UserDAO {
	int insertUser(User user);
	 List<User> getAllUsers();
	User getUserById(int id);
	int deleteUserByI(int id);
	int updateUserById(int id,String address);
}
