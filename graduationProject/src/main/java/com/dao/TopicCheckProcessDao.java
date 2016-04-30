package com.dao;

import com.beans.TopicCheckProcess;
import com.beans.TopicProcess;

public interface TopicCheckProcessDao {

	public void saveTopicCheckProcess(TopicCheckProcess topicCheckProcess) throws Exception;

	public TopicCheckProcess get() throws Exception;


	
}
