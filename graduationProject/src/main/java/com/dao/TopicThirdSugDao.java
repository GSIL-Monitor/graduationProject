package com.dao;

import com.beans.TopicThirdSug;

public interface TopicThirdSugDao {

	public void saveTopicThirdSug(TopicThirdSug topicThirdSug) throws Exception;

	public TopicThirdSug getTopicThirdSugByTopicId(String topic_id) throws Exception;

	public void updateTopicThirdSug(TopicThirdSug topicThirdSug) throws Exception;


	
}
