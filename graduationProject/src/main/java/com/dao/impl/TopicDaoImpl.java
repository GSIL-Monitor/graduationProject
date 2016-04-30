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
		Session session;//hibernate会话
		Transaction transaction; //hiberante事务
		session=sessionFactory.getCurrentSession();
		transaction = session.beginTransaction();
		session.save(topic);
		transaction.commit();
		session.close();
	}
	public List getTopicByTeacherId(String teacher_id,String sqlWhere) throws Exception {
		Session session;//hibernate会话
		session=sessionFactory.openSession();
		String selectHql="select topic from Topic as topic where topic.teacherId=? and "+sqlWhere;
		Query query=session.createQuery(selectHql);
		query.setString(0, teacher_id);
		List<Topic> list=query.list();
		session.close();
		return list;
	}
	public Topic getTopicByTopicId(String topic_id) throws Exception {
		Topic topic=null;
		Session session;//hibernate会话
		session=sessionFactory.openSession();
		String selectHql="select topic from Topic as topic where topic.topic_id=?";
		Query query=session.createQuery(selectHql);
		query.setString(0, topic_id);
		List<Topic> list=query.list();
		if (!list.isEmpty()){
			topic=list.get(0);
		}
		session.close();
		return topic;
	}
	public void updateTopic(Topic topic) throws Exception {
		Session session;//hibernate会话
		session=sessionFactory.openSession();
		Transaction transaction; //hiberante事务
		transaction = session.beginTransaction();
		String selectHql="select topic from Topic as topic where topic.topic_id=?";
		Query query=session.createQuery(selectHql);
		query.setString(0, topic.getTopic_id());
		List<Topic> list=query.list();
		if (!list.isEmpty()){
			Topic sqlTopic=list.get(0);
			sqlTopic.setStatus(topic.getStatus());
			sqlTopic.setName(topic.getName());
			sqlTopic.setPhysical(topic.getPhysical());
			sqlTopic.setIsAnswer(topic.getIsAnswer());
			sqlTopic.setIsTrial(topic.getIsTrial());
			sqlTopic.setIsTutorWork(topic.getIsTutorWork());
			sqlTopic.setType(topic.getType());
			session.update(sqlTopic);
		}
		transaction.commit();
		session.close();
	}
	public void lockTopic(String topic_id) throws Exception {
		Session session;//hibernate会话
		session=sessionFactory.openSession();
		Transaction transaction; //hiberante事务
		transaction = session.beginTransaction();
		String selectHql="select topic from Topic as topic where topic.topic_id=?";
		Query query=session.createQuery(selectHql);
		query.setString(0, topic_id);
		List<Topic> list=query.list();
		if (!list.isEmpty()){
			Topic topic=list.get(0);
			topic.setIs_selected(1);
			session.update(topic);
		}
		transaction.commit();
		session.close();
	}
	public void unLockTopic(String topic_id) throws Exception {
		Session session;//hibernate会话
		session=sessionFactory.openSession();
		Transaction transaction; //hiberante事务
		transaction = session.beginTransaction();
		String selectHql="select topic from Topic as topic where topic.topic_id=?";
		Query query=session.createQuery(selectHql);
		query.setString(0, topic_id);
		List<Topic> list=query.list();
		if (!list.isEmpty()){
			Topic topic=list.get(0);
			topic.setIs_selected(0);
			session.update(topic);
		}
		transaction.commit();
		session.close();
	}
	public List queryAllTopics(String sqlWhere) throws Exception {
		Session session;//hibernate会话
		session=sessionFactory.openSession();
		String selectHql="select topic from Topic as topic where "+sqlWhere;
		Query query=session.createQuery(selectHql);
		List<Topic> list=query.list();
		session.close();
		return list;
	}
	public List queryAllTopicBymajorName(String majorName) throws Exception {
		Session session;//hibernate会话
		session=sessionFactory.openSession();
		String selectHql="select topic from Topic as topic where topic.majorName=? and topic.status=2";
		Query query=session.createQuery(selectHql);
		query.setString(0, majorName);
		List<Topic> list=query.list();
		session.close();
		return list;
	}
	public List queryAllTopicsByStatus(String teacher_id,String statusSql){
		Session session;//hibernate会话
		session=sessionFactory.openSession();
		String selectHql="select topic from topic as topic where topic.topic_id in (select topicStatus.topicId from TopicStatus as topicStatus where "+statusSql+") ";
		Query query=session.createQuery(selectHql);
		List<Topic> list=query.list();
		session.close();
		return list;
	}

	public long countTopic(String sqlWhere) {
		Session session;//hibernate会话
		session=sessionFactory.openSession();
		String selectHql="select count(*) from Topic as topic where "+sqlWhere;
		Query query=session.createQuery(selectHql);
		long sum=((Number)query.uniqueResult()).longValue();
		session.close();
		return sum;
	}
	public long countTopicByteacher(String sqlWhere,String teacher_id) {
		Session session;//hibernate会话
		session=sessionFactory.openSession();
		String selectHql="select count(*) from Topic as topic where topic.teacherId=? and "+sqlWhere;
		Query query=session.createQuery(selectHql);
		query.setString(0,teacher_id);
		long sum=((Number)query.uniqueResult()).longValue();
		session.close();
		return sum;
	}
}
