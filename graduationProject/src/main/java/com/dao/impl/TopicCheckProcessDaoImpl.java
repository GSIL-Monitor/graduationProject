package com.dao.impl;

import com.beans.TopicCheckProcess;
import com.beans.TopicProcess;
import com.dao.TopicCheckProcessDao;
import com.dao.TopicProcessDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;


public class TopicCheckProcessDaoImpl implements TopicCheckProcessDao {
	private SessionFactory sessionFactory;


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public void saveTopicCheckProcess(TopicCheckProcess topicCheckProcess) throws Exception {
		Session session;//hibernate会话
		Transaction transaction; //hiberante事务
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		String selectHql="select topicCheckProcess from TopicCheckProcess as topicCheckProcess";
		Query query=session.createQuery(selectHql);
		List<TopicCheckProcess> list=query.list();
		if (!list.isEmpty()){
			TopicCheckProcess sqltopicCheckProcess=list.get(0);
			sqltopicCheckProcess.setTopicCommitBegin(topicCheckProcess.getTopicCommitBegin());
			sqltopicCheckProcess.setTopicCommitEnd(topicCheckProcess.getTopicCommitEnd());
			sqltopicCheckProcess.setChoiceBegin(topicCheckProcess.getChoiceBegin());
			sqltopicCheckProcess.setChoiceEnd(topicCheckProcess.getChoiceEnd());
			sqltopicCheckProcess.setTopicBegin(topicCheckProcess.getTopicBegin());
			sqltopicCheckProcess.setTopicEnd(topicCheckProcess.getTopicEnd());
			sqltopicCheckProcess.setTopicMidBegin(topicCheckProcess.getTopicMidBegin());
			sqltopicCheckProcess.setTopicMidEnd(topicCheckProcess.getTopicMidEnd());
			sqltopicCheckProcess.setTopicFinalBegin(topicCheckProcess.getTopicFinalBegin());
			sqltopicCheckProcess.setTopicFinalEnd(topicCheckProcess.getTopicFinalEnd());
			session.update(sqltopicCheckProcess);
		}else {
			session.save(topicCheckProcess);
		}
		transaction.commit();
		session.close();
	}

	public TopicCheckProcess get() throws Exception {
		TopicCheckProcess topicCheckProcess=null;
		Session session;//hibernate会话
		session=sessionFactory.openSession();
		String selectHql="select topicCheckProcess from TopicCheckProcess as topicCheckProcess";
		Query query=session.createQuery(selectHql);
		List<TopicCheckProcess> list=query.list();
		if (!list.isEmpty()){
			topicCheckProcess=list.get(0);
		}
		session.close();
		return topicCheckProcess;
	}
}
