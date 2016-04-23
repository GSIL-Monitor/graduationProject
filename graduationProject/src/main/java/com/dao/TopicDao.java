package com.dao;

import com.beans.Topic;
import com.beans.User;

import java.util.List;

public interface TopicDao {

	public void saveTopic(Topic topic) throws Exception;

	public void updateTopic(Topic topic) throws Exception;
	
	public List queryAllTopics() throws Exception;

	
}
