package com.dao.impl;

import com.beans.TopicFinalInfo;
import com.beans.TopicProcess;
import com.beans.TopicStatus;
import com.dao.TopicProcessDao;
import com.dao.TopicStatusDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;


public class TopicProcessDaoImpl implements TopicProcessDao{
	private SessionFactory sessionFactory;


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public void saveTopicProcess(TopicProcess topicProcess) throws Exception {
		System.out.println("sql:" + topicProcess.toString());
		Session session;//hibernate会话
		Transaction transaction; //hiberante事务
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		String selectHql="select topicProcess from TopicProcess as topicProcess";
		Query query=session.createQuery(selectHql);
		List<TopicProcess> list=query.list();
		if (!list.isEmpty()){
			TopicProcess sqltopicProcess=list.get(0);
			sqltopicProcess.setChoiceBegin(topicProcess.getChoiceBegin());
			sqltopicProcess.setChoiceEnd(topicProcess.getChoiceEnd());
			sqltopicProcess.setTopicBegin(topicProcess.getTopicBegin());
			sqltopicProcess.setTopicEnd(topicProcess.getTopicEnd());
			sqltopicProcess.setTopicMidBegin(topicProcess.getTopicMidBegin());
			sqltopicProcess.setTopicMidEnd(topicProcess.getTopicMidEnd());
			sqltopicProcess.setTopicFinalBegin(topicProcess.getTopicFinalBegin());
			sqltopicProcess.setTopicFinalEnd(topicProcess.getTopicFinalEnd());
			session.update(sqltopicProcess);
		}else {
			session.save(topicProcess);
		}
		transaction.commit();
		session.close();
	}

	public TopicProcess get() throws Exception {
		TopicProcess topicProcess=null;
		Session session;//hibernate会话
		session=sessionFactory.openSession();
		String selectHql="select topicProcess from TopicProcess as topicProcess";
		Query query=session.createQuery(selectHql);
		List<TopicProcess> list=query.list();
		if (!list.isEmpty()){
			topicProcess=list.get(0);
		}
		session.close();
		return topicProcess;
	}
}
