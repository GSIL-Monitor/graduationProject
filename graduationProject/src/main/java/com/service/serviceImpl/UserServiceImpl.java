package com.service.serviceImpl;

import com.beans.SumBean;
import com.beans.User;
import com.dao.TopicDao;
import com.dao.UserDao;
import com.opensymphony.xwork2.ActionContext;
import com.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * Created by wuhao on 16/4/16.
 */
public class UserServiceImpl implements UserService{
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private UserDao userDao;
    private TopicDao topicDao;

    public TopicDao getTopicDao() {
        return topicDao;
    }

    public void setTopicDao(TopicDao topicDao) {
        this.topicDao = topicDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public String checkLogin(String username,String password) {
        try {
            Map session =ActionContext.getContext().getSession();
            if(!userDao.UserIsExit(username)){
                return "该帐号不存在";
            }
            User user=userDao.getUser(username, password);
            if (user==null){
                return "密码错误";
            }
            session.put("user", user);
            return null;
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return "登录失败,请重试";
    }

    public void update(User user) {
        try {
            userDao.updateUser(user);
        }catch (Exception e){
            logger.error(e.getMessage());
        }
    }

    public void saveUser(User user) {
        try {
            userDao.saveUser(user);
        }catch (Exception e){
            logger.error(e.getMessage());
        }

    }
    public User getUser(String uid){
        User user=new User();
        try {
            user=userDao.getUser(uid);
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return user;
    }

    public List queryAllUsers() {
        try {
            return userDao.queryAllUsers();
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return null;
    }

    public SumBean count() {
        SumBean sumBean=new SumBean();
        try {
            sumBean.setStudentCount(userDao.countUser("user.type=1"));
            sumBean.setTeacherCount(userDao.countUser("user.type=2"));
            sumBean.setTopicCount(topicDao.countTopic("1=1"));
            sumBean.setTopicPendingCount(topicDao.countTopic("topic.status=1"));
        }catch (Exception e){
            e.printStackTrace();
        }
        return sumBean;
    }
}
