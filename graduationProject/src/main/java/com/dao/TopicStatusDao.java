package com.dao;

import com.beans.Topic;
import com.beans.TopicStatus;
import com.service.TopicService;

import java.util.List;

public interface TopicStatusDao {

	public void saveTopicStatus(TopicStatus topicStatus) throws Exception;

	public TopicStatus getTopicStatusByTopicId(String topic_id) throws Exception;

	public void updateTopicStatus(TopicStatus topicStatus) throws Exception;


	
}
