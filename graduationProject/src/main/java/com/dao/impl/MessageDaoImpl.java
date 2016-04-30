package com.dao.impl;

import com.beans.Message;
import com.beans.Topic;
import com.dao.MessageDao;
import com.dao.TopicDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;


public class MessageDaoImpl implements MessageDao{
	private SessionFactory sessionFactory;


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public void saveMessage(Message message) throws Exception {
		Session session;//hibernate会话
		Transaction transaction; //hiberante事务
		session=sessionFactory.openSession();
		transaction = session.beginTransaction();
		session.save(message);
		transaction.commit();
		session.close();
	}

	public void updateMessage(Message message) throws Exception {
		Session session;//hibernate会话
		Transaction transaction; //hiberante事务
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		String selectHql="select message from Message as message where message.id=?";
		Query query=session.createQuery(selectHql);
		query.setLong(0,message.getId());
		List<Message> list=query.list();
		if (!list.isEmpty()){
			Message sqlmessage=list.get(0);
			sqlmessage.setStatus(message.getStatus());
			sqlmessage.setAccessTimes(message.getAccessTimes());
			session.update(sqlmessage);
		}
		transaction.commit();
		session.close();
	}

	public Message getMessageById(long id) throws Exception{
		Session session;//hibernate会话
		session=sessionFactory.openSession();
		String selectHql="select message from Message as message where message.id=?";
		Query query=session.createQuery(selectHql);
		query.setLong(0,id);
		List<Message> list=query.list();
		if (!list.isEmpty()){
			Message sqlmessage=list.get(0);
			return sqlmessage;
		}
		session.close();
		return null;
	}

	public List queryAllMessages() throws Exception {
		Session session;//hibernate会话
		session=sessionFactory.openSession();
		String selectHql="select message from Message as message where message.status=1";
		Query query=session.createQuery(selectHql);
		List<Message> list=query.list();
		session.close();
		return list;
	}
}
