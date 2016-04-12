package com.actions;

import java.util.List;

import com.beans.User;
import com.dao.UserDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {

	private User user;
	
	private UserDao userDao ;
	
	public String save() throws Exception{
		System.out.println("hehe"+user.getUsername());
		userDao.saveUser(user);
		return SUCCESS;
	}
	
	public String selectAll() throws Exception{
		List users = userDao.queryAllUsers();
		ActionContext.getContext().put("users", users);
		return "result2";
	}
	public String login() throws Exception{
		System.out.print("praram:"+user.toString());
		return SUCCESS;
	}
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	
	
}
