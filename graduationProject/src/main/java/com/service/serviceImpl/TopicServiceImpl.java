package com.service.serviceImpl;

import com.beans.Topic;
import com.beans.User;
import com.dao.TopicDao;
import com.dao.UserDao;
import com.opensymphony.xwork2.ActionContext;
import com.service.TopicService;
import com.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * Created by wuhao on 16/4/16.
 */
public class TopicServiceImpl implements TopicService{
    private static final Logger logger = LoggerFactory.getLogger(TopicServiceImpl.class);
    private TopicDao topicDao;

    public TopicDao getTopicDao() {
        return topicDao;
    }

    public void setTopicDao(TopicDao topicDao) {
        this.topicDao = topicDao;
    }


    public void update(Topic topic) {

    }

    public void save(Topic topic) {

    }

    public List queryAllUsers() {
        return null;
    }
}
