package com.dao;

import java.util.List;

import com.beans.User;

public interface UserDao {

	public void saveUser(User user) throws Exception;

	public void updateUser(User user) throws Exception;
	
	public List queryAllUsers() throws Exception;

	public User getUser(String username,String password) throws Exception;

	public boolean UserIsExit(String username) throws Exception;
	
}
