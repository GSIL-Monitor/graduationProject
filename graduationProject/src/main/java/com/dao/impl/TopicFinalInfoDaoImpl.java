package com.dao.impl;

import com.beans.TopicFinalInfo;
import com.beans.TopicStatus;
import com.dao.TopicFinalInfoDao;
import com.dao.TopicStatusDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;


public class TopicFinalInfoDaoImpl implements TopicFinalInfoDao{
	private SessionFactory sessionFactory;


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void saveTopicFinalInfo(TopicFinalInfo topicFinalInfo) throws Exception {
		Session session;//hibernate会话
		Transaction transaction; //hiberante事务
		session=sessionFactory.getCurrentSession();
		transaction = session.beginTransaction();
		session.save(topicFinalInfo);
		transaction.commit();
		session.close();
	}

	public TopicFinalInfo getTopicFinalInfoByTopicId(String topic_id) throws Exception {
		TopicFinalInfo topicFinalInfo=null;
		Session session;//hibernate会话
		session=sessionFactory.openSession();
		String selectHql="select topicFinalInfo from TopicFinalInfo as topicFinalInfo where topicFinalInfo.topic_id=?";
		Query query=session.createQuery(selectHql);
		query.setString(0, topic_id);
		List<TopicFinalInfo> list=query.list();
		if (!list.isEmpty()){
			topicFinalInfo=list.get(0);
		}
		session.close();
		return topicFinalInfo;
	}

	public void updateTopicFinalInfo(TopicFinalInfo topicFinalInfo) throws Exception {
		Session session;//hibernate会话
		Transaction transaction; //hiberante事务
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		String selectHql="select topicFinalInfo from TopicFinalInfo as topicFinalInfo where topicFinalInfo.topic_id=?";
		Query query=session.createQuery(selectHql);
		query.setString(0,topicFinalInfo.getTopic_id());
		List<TopicFinalInfo> list=query.list();
		if (!list.isEmpty()){
			TopicFinalInfo sqltopicFinalInfo=list.get(0);
			sqltopicFinalInfo.setIsSavePdf(topicFinalInfo.getIsSavePdf());
			sqltopicFinalInfo.setIsSaveWord(topicFinalInfo.getIsSaveWord());
			sqltopicFinalInfo.setPdfName(topicFinalInfo.getPdfName());
			sqltopicFinalInfo.setWordName(topicFinalInfo.getWordName());
			session.update(sqltopicFinalInfo);
		}
		transaction.commit();
		session.close();
	}
}
