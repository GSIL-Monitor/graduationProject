package com.dao;

import com.beans.Topic;
import com.beans.User;

import java.util.List;

public interface TopicDao {

	public void saveTopic(Topic topic) throws Exception;

	public List getTopicByTeacherId(String teacher_id,String sqlWhere) throws Exception;

	public Topic getTopicByTopicId(String topic_id) throws Exception;

	public void updateTopic(Topic topic) throws Exception;
	
	public List queryAllTopics(String sqlWhere) throws Exception;

	public List queryAllTopicBymajorName(String majorName) throws Exception;

	public void lockTopic(String topic_id) throws Exception;

	public void unLockTopic(String topic_id) throws Exception;

	public List queryAllTopicsByStatus(String teacher_id,String statusSql);

	public long countTopic(String sqlWhere);

	public long countTopicByteacher(String sqlWhere,String teacher_id);
}
