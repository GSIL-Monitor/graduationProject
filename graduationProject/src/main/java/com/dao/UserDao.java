package com.dao;

import java.util.List;

import com.beans.User;

public interface UserDao {

	public void saveUser(User user);
	
	public List queryAllUsers();
	
}
