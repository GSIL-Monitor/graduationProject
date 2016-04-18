package com.service;

import com.beans.User;

import java.util.List;

/**
 * Created by wuhao on 16/4/16.
 */
public interface UserService {

    public String checkLogin(String username,String password);

    public void update(User user);

    public void saveUser(User user);

    public List queryAllUsers();
}
