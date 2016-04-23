package com.dao;

import com.beans.Message;
import com.beans.Topic;

import java.util.List;

public interface MessageDao {

	public void saveMessage(Message message) throws Exception;

	public void updateMessage(Message message) throws Exception;
	
	public List queryAllMessages() throws Exception;

	
}
