package com.actions;

import com.beans.Message;
import com.beans.Topic;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.MessageService;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.InputStream;

public class MessageAction extends ActionSupport {
	private long id;

	private MessageService messageService;

	private String docName;

	private String fileName;

	private InputStream fileInputStream;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public InputStream getFileInputStream() {
		return fileInputStream;
	}

	public void setFileInputStream(InputStream fileInputStream) {
		this.fileInputStream = fileInputStream;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public MessageService getMessageService() {
		return messageService;
	}

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

	public String detail(){
		Message message=messageService.get(id);
		message.setAccessTimes(message.getAccessTimes()+1);
		messageService.update(message);
		ActionContext.getContext().getSession().put("message",message);
		return "detail";
	}
	public String download(){
		fileName=docName;
		fileInputStream=messageService.getInputStream(docName);
		return "download";
	}
}
