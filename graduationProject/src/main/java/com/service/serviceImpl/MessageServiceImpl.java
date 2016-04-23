package com.service.serviceImpl;

import com.beans.Message;
import com.beans.Topic;
import com.dao.MessageDao;
import com.dao.TopicDao;
import com.service.MessageService;
import com.service.TopicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by wuhao on 16/4/16.
 */
public class MessageServiceImpl implements MessageService{
    private static final Logger logger = LoggerFactory.getLogger(MessageServiceImpl.class);
    private MessageDao messageDao;

    public void setMessageDao(MessageDao messageDao) {
        this.messageDao = messageDao;
    }

    public MessageDao getMessageDao() {
        return messageDao;
    }


    public void update(Message message) {

    }

    public void save(Message message) {

    }

    public List queryAllMessages() {
        return null;
    }
}
