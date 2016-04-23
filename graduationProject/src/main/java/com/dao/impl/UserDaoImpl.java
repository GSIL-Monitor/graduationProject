package com.dao.impl;

import java.util.List;

import com.beans.Student;
import org.hibernate.Query;
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

	public void saveUser(User user) throws Exception{
		Session session;//hibernate会话
		Transaction transaction; //hiberante事务
		session=sessionFactory.getCurrentSession();
		transaction = session.beginTransaction();
		session.save(user);
		transaction.commit();
	}

	public void updateUser(User user) throws Exception {
		Session session;//hibernate会话
		Transaction transaction; //hiberante事务
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		String selectHql="select u from User as u where u.user_id=?";
		Query query=session.createQuery(selectHql);
		query.setString(0, user.getUser_id());
		List<User> list=query.list();
		if (!list.isEmpty()){
			User userSql=list.get(0);
			userSql.setPassword(user.getPassword());
			session.update(userSql);
		}
		transaction.commit();
		session.close();
	}

	public List queryAllUsers() throws Exception{
		Session session;//hibernate会话
		session=sessionFactory.openSession();
		List list=session.createQuery("select u from User as u").list();
		session.close();
		return list;
	}

	public User getUser(String username,String password) throws Exception{
		Session session;//hibernate会话
		session=sessionFactory.openSession();
		String selectHql="select u from User as u where u.username=? and u.password=? and u.status=1";
		Query query=session.createQuery(selectHql);
		query.setString(0,username);
		query.setString(1,password);
		List<User> list=query.list();
		session.close();
		if (list.isEmpty()) {
			return null;
		}else {
			return list.get(0);
		}
	}
	public boolean UserIsExit(String username) throws Exception {
		Session session;//hibernate会话
		session=sessionFactory.openSession();
		String selectHql="select u from User as u where u.username=?";
		Query query=session.createQuery(selectHql);
		query.setString(0,username);
		List<User> list=query.list();
		session.close();
		if (list.isEmpty()) {
			return false;
		}else {
			return true;
		}
	}

	
}
