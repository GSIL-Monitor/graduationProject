package com.actions;

import com.beans.Message;
import com.beans.Topic;
import com.opensymphony.xwork2.ActionSupport;
import com.service.MessageService;

public class MessageAction extends ActionSupport {
	private Message message;
	private MessageService messageService;

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public MessageService getMessageService() {
		return messageService;
	}

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

	public String detail(){
		return "detail";
	}
}
