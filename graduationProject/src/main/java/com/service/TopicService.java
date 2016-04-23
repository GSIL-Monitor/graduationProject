package com.service;

import com.beans.Topic;

import java.util.List;

/**
 * Created by wuhao on 16/4/16.
 */
public interface TopicService {

    public void update(Topic topic);

    public void save(Topic topic);

    public List queryAllUsers();
}
