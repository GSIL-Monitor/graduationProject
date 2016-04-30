package com.service.serviceImpl;

import com.beans.Message;
import com.beans.Topic;
import com.beans.User;
import com.dao.MessageDao;
import com.dao.TopicDao;
import com.opensymphony.xwork2.ActionContext;
import com.service.MessageService;
import com.service.TopicService;
import com.utils.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
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
        try {
            messageDao.updateMessage(message);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void save(Message message,File docFile,String fileName) {
        try {
             if (docFile!=null) {
                 fileName=FileUtils.formatFileName(fileName);
                 FileUtils.saveFile(fileName,docFile);
                 message.setDocName(fileName);
                 message.setIsHaveDoc(1);
             }
            messageDao.saveMessage(message);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public List queryAllMessages() {
        List messageList=new ArrayList();
        try {
            messageList=messageDao.queryAllMessages();
        }catch (Exception e){
            e.printStackTrace();
        }
        return messageList;
    }
    public Message get(long id){
       Message message=new Message();
        try {
            message=messageDao.getMessageById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return message;
    }
    public InputStream getInputStream(String fileName){
        try {
            return FileUtils.getFile(fileName);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
