package com.dao;

import com.beans.TopicFinalInfo;
import com.beans.TopicStatus;

public interface TopicFinalInfoDao {

	public void saveTopicFinalInfo(TopicFinalInfo topicFinalInfo) throws Exception;

	public TopicFinalInfo getTopicFinalInfoByTopicId(String topic_id) throws Exception;

	public void updateTopicFinalInfo(TopicFinalInfo topicFinalInfo) throws Exception;


	
}
