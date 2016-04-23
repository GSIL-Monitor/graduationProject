package com.dao.impl;

import com.beans.Topic;
import com.beans.User;
import com.dao.TopicDao;
import com.dao.UserDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;


public class TopicDaoImpl implements TopicDao{
	private SessionFactory sessionFactory;


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public void saveTopic(Topic topic) throws Exception {

	}

	public void updateTopic(Topic topic) throws Exception {

	}

	public List queryAllTopics() throws Exception {
		return null;
	}
}
