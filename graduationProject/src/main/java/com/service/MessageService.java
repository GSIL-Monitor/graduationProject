package com.service;

import com.beans.Message;
import com.beans.Topic;

import java.util.List;

/**
 * Created by wuhao on 16/4/16.
 */
public interface MessageService {

    public void update(Message message);

    public void save(Message message);

    public List queryAllMessages();
}
