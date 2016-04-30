package com.service;

import com.beans.SumBean;
import com.beans.User;

import java.util.List;

/**
 * Created by wuhao on 16/4/16.
 */
public interface UserService {

    public String checkLogin(String username,String password);

    public void update(User user);

    public void saveUser(User user);

    public User getUser(String uid);

    public List queryAllUsers();

    public SumBean count();
}
