package com.dao;

import com.beans.TopicFinalInfo;
import com.beans.TopicProcess;

public interface TopicProcessDao {

	public void saveTopicProcess(TopicProcess topicProcess) throws Exception;

	public TopicProcess get() throws Exception;


	
}
