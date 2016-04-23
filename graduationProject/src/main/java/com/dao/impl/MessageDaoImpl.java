package com.dao.impl;

import com.beans.Message;
import com.beans.Topic;
import com.dao.MessageDao;
import com.dao.TopicDao;
import org.hibernate.SessionFactory;

import java.util.List;


public class MessageDaoImpl implements MessageDao{
	private SessionFactory sessionFactory;


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public void saveMessage(Message message) throws Exception {

	}

	public void updateMessage(Message message) throws Exception {

	}

	public List queryAllMessages() throws Exception {
		return null;
	}
}
