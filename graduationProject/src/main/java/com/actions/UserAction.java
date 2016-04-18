package com.actions;

import java.util.List;
import java.util.Map;

import com.beans.User;
import com.dao.UserDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.UserService;
import com.utils.RoleUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserAction extends ActionSupport {

	private String username;

	private String password;

	private String pwd;

	private String email;
	
	private UserService userService;

	private static final Logger logger = LoggerFactory.getLogger(UserAction.class);

	public String getUsername() {
		return username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public void add() {

	}
	public String login() {
		String result=userService.checkLogin(username, password);
		if (result==null){
			User user=(User)ActionContext.getContext().getSession().get("user");
			return RoleUtils.checkRoleType(user.getType());
		}else {
			ActionContext.getContext().put("loginError", result);
			return LOGIN;
		}
	}
	public String logout() {
		ActionContext.getContext().getSession().clear();
		return LOGIN;
	}
	public String update() {
		User user=(User)ActionContext.getContext().getSession().get("user");

		if (user.getPassword().equals(password)){
			user.setPassword(pwd.trim());
			ActionContext.getContext().put("user", user);
			userService.update(user);
		}else {
			ActionContext.getContext().put("passError", "该用户密码与你输入的密码不匹配");
			return RoleUtils.checkRoleType(user.getType())+"_UPDATE";
		}
		return RoleUtils.checkRoleType(user.getType());
	}
	
}
