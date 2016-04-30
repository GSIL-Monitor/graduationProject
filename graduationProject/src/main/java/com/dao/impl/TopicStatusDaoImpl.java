package com.dao.impl;

import com.beans.Topic;
import com.beans.TopicStatus;
import com.dao.TopicDao;
import com.dao.TopicStatusDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;


public class TopicStatusDaoImpl implements TopicStatusDao{
	private SessionFactory sessionFactory;


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void saveTopicStatus(TopicStatus topicStatus) throws Exception {
		Session session;//hibernate会话
		Transaction transaction; //hiberante事务
		session=sessionFactory.getCurrentSession();
		transaction = session.beginTransaction();
		session.save(topicStatus);
		transaction.commit();
		session.close();
	}

	public TopicStatus getTopicStatusByTopicId(String topic_id) throws Exception {
		TopicStatus topicStatus=null;
		Session session;//hibernate会话
		session=sessionFactory.openSession();
		String selectHql="select topicStatus from TopicStatus as topicStatus where topicStatus.topicId=?";
		Query query=session.createQuery(selectHql);
		query.setString(0, topic_id);
		List<TopicStatus> list=query.list();
		if (!list.isEmpty()){
			topicStatus=list.get(0);
		}
		session.close();
		return topicStatus;
	}

	public void updateTopicStatus(TopicStatus topicStatus) throws Exception {
		Session session;//hibernate会话
		Transaction transaction; //hiberante事务
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		String selectHql="select topicStatus from TopicStatus as topicStatus where topicStatus.topicId=?";
		Query query=session.createQuery(selectHql);
		query.setString(0,topicStatus.getTopicId());
		List<TopicStatus> list=query.list();
		if (!list.isEmpty()){
			TopicStatus sqlTopicStatus=list.get(0);
			sqlTopicStatus.setBeginScore(topicStatus.getBeginScore());
			sqlTopicStatus.setMidScore(topicStatus.getMidScore());
			sqlTopicStatus.setFinalScore(topicStatus.getFinalScore());
			sqlTopicStatus.setTopicBegin(topicStatus.getTopicBegin());
			sqlTopicStatus.setTopicMid(topicStatus.getTopicMid());
			sqlTopicStatus.setTopicFinal(topicStatus.getTopicFinal());
			session.update(sqlTopicStatus);
		}
		transaction.commit();
		session.close();
	}
}
