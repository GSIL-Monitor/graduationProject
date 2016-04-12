package com.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.beans.User;
import com.dao.UserDao;


public class UserDaoImpl  implements UserDao {
	private SessionFactory sessionFactory;


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void saveUser(User user) {
		Session session;//hibernate会话
		Transaction transaction; //hiberante事务
		session=sessionFactory.getCurrentSession();
		transaction = session.beginTransaction();
		session.save(user);
		transaction.commit();
	}

	public List queryAllUsers() {
		Session session;//hibernate会话
		session=sessionFactory.openSession();
		List list=session.createQuery("select u from User as u").list();
		session.close();
		return list;
	}

	
}
