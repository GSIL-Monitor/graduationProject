package com.dao.impl;

import com.beans.TopicFinalInfo;
import com.beans.TopicThirdSug;
import com.dao.TopicThirdSugDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;


public class TopicThirdSugDaoImpl implements TopicThirdSugDao{
	private SessionFactory sessionFactory;


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void saveTopicThirdSug(TopicThirdSug topicThirdSug) throws Exception {
		Session session;//hibernate会话
		Transaction transaction; //hiberante事务
		session=sessionFactory.getCurrentSession();
		transaction = session.beginTransaction();
		session.save(topicThirdSug);
		transaction.commit();
		session.close();
	}

	public TopicThirdSug getTopicThirdSugByTopicId(String topic_id) throws Exception {
		TopicThirdSug topicThirdSug=null;
		Session session;//hibernate会话
		session=sessionFactory.openSession();
		String selectHql="select topicThirdSug from TopicThirdSug as topicThirdSug where topicThirdSug.topic_id=?";
		Query query=session.createQuery(selectHql);
		query.setString(0, topic_id);
		List<TopicThirdSug> list=query.list();
		if (!list.isEmpty()){
			topicThirdSug=list.get(0);
		}
		session.close();
		return topicThirdSug;
	}

	public void updateTopicThirdSug(TopicThirdSug topicThirdSug) throws Exception {
		Session session;//hibernate会话
		Transaction transaction; //hiberante事务
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		String selectHql="select topicThirdSug from TopicThirdSug as topicThirdSug where topicThirdSug.topic_id=?";
		Query query=session.createQuery(selectHql);
		query.setString(0,topicThirdSug.getTopic_id());
		List<TopicThirdSug> list=query.list();
		if (!list.isEmpty()){
			TopicThirdSug sqltopicThirdSug=list.get(0);
			sqltopicThirdSug.setBegin_sug(topicThirdSug.getBegin_sug());
			sqltopicThirdSug.setMid_sug(topicThirdSug.getMid_sug());
			sqltopicThirdSug.setEnd_sug(topicThirdSug.getEnd_sug());
			session.update(sqltopicThirdSug);
		}
		transaction.commit();
		session.close();
	}
}
