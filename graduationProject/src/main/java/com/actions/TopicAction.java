package com.actions;

import com.beans.Student;
import com.beans.Topic;
import com.opensymphony.xwork2.ActionSupport;
import com.service.StudentService;
import com.service.TopicService;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TopicAction extends ActionSupport {
	private Topic topic;
	private TopicService topicService;

	public TopicService getTopicService() {
		return topicService;
	}

	public void setTopicService(TopicService topicService) {
		this.topicService = topicService;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public String detail(){
		return "detail";
	}

	public String beginCheck() {
		return "BEGIN_CHECK";
	}
	public String beginRead() {
		return "BEGIN_READ";
	}
	public String midCheck() {
		return "MID_CHECK";
	}
	public String midRead() {
		return "MID_READ";
	}
	public String finalCheck() {
		return "FINAL_CHECK";
	}
	public String input() throws Exception{
		System.out.println("topic:" + topic.toString());
		return "home";
	}

}
