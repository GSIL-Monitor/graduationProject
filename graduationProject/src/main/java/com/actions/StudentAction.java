package com.actions;

import com.beans.*;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.MessageService;
import com.service.StudentService;
import com.service.TopicService;
import com.service.UserService;
import com.utils.RoleUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.management.relation.Role;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class StudentAction extends ActionSupport {

	private InputStream inputStream;

	private Student student;

	private StudentService studentService;

	private TopicService topicService;

	private MessageService messageService;

	private String content;

	private String topic_id;

	private File word;

	private String wordFileName;

	private String wordContentType;

	private File pdf;

	private String pdfFileName;

	private String pdfContentType;

	private static final Logger logger = LoggerFactory.getLogger(StudentAction.class);

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public File getWord() {
		return word;
	}

	public void setWord(File word) {
		this.word = word;
	}

	public String getWordFileName() {
		return wordFileName;
	}

	public void setWordFileName(String wordFileName) {
		this.wordFileName = wordFileName;
	}

	public String getWordContentType() {
		return wordContentType;
	}

	public void setWordContentType(String wordContentType) {
		this.wordContentType = wordContentType;
	}

	public File getPdf() {
		return pdf;
	}

	public void setPdf(File pdf) {
		this.pdf = pdf;
	}

	public String getPdfFileName() {
		return pdfFileName;
	}

	public void setPdfFileName(String pdfFileName) {
		this.pdfFileName = pdfFileName;
	}

	public String getPdfContentType() {
		return pdfContentType;
	}

	public void setPdfContentType(String pdfContentType) {
		this.pdfContentType = pdfContentType;
	}

	public MessageService getMessageService() {
		return messageService;
	}

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

	public String getTopic_id() {
		return topic_id;
	}

	public void setTopic_id(String topic_id) {
		this.topic_id = topic_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public TopicService getTopicService() {
		return topicService;
	}

	public void setTopicService(TopicService topicService) {
		this.topicService = topicService;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public String home(){
		Map session =ActionContext.getContext().getSession();
		User user=(User)session.get("user");
		student=studentService.getStudent(user.getUser_id());
		Topic topic= topicService.getTopicByTopicId(student.getTopic_id());
		TopicStatus topicStatus=topicService.getTopicStatus(topic.getTopic_id());
		TopicProcess topicProcess=studentService.getPer();
		double allScore= RoleUtils.countScore(topicStatus);
		session.put("topicProcess", topicProcess);
		session.put("topicStatus", topicStatus);
		session.put("topic",topic);
		session.put("allScore", allScore);
		return "home";
	}
	public String update(){
		studentService.update(student);
		return SUCCESS;
	}
	public String info(){
		Map session=ActionContext.getContext().getSession();
		User user=(User)session.get("user");
		Student student=studentService.getStudent(user.getUser_id());
		session.put("student", student);
		return "info";
	}
	public String messageDetail(){
		return "messageDetail";
	}
	public String message(){
		List messageList=messageService.queryAllMessages();
		ActionContext.getContext().getSession().put("messageList", messageList);
		return "message";
	}
	public String choice(){
		Map session=ActionContext.getContext().getSession();
		User user=(User)session.get("user");
		Student student=studentService.getStudent(user.getUser_id());
		session.put("student",student);
		String sqlwhere="topic.topic_id not in (select student.topic_id from Student as student where student.status=1)";
		List<Topic> topicList=topicService.queryAllTopicBymajorName(student.getMajorName(),sqlwhere);
		session.put("topicList", topicList);
		return "choice";
	}
	public String begin(){
		Map session =ActionContext.getContext().getSession();
		User user=(User)session.get("user");
		student=studentService.getStudent(user.getUser_id());
		TopicStatus topicStatus=topicService.getTopicStatus(student.getTopic_id());
		if (topicStatus.getTopicBegin()!=0){
			return "home";
		}
		TopicThirdSug topicThirdSug=studentService.getSug(user.getUser_id());
		Report report = topicService.getTopicReport(student.getTopic_id());
		session.put("topicThirdSug", topicThirdSug);
		session.put("report", report);
		return "begin";
	}
	public String beginSave(){
		topicService.commit(topic_id, content, "begin");
		return "home";
	}
	public String midSave(){
		topicService.commit(topic_id, content, "mid");
		return "home";
	}
	public String beginRead(){
		Map session =ActionContext.getContext().getSession();
		User user=(User)session.get("user");
		student=studentService.getStudent(user.getUser_id());
		TopicThirdSug topicThirdSug=studentService.getSug(user.getUser_id());
		Report report = topicService.getTopicReport(student.getTopic_id());
		session.put("topicThirdSug",topicThirdSug);
		session.put("report", report);
		return "beginRead";
	}
	public String mid(){
		Map session =ActionContext.getContext().getSession();
		User user=(User)session.get("user");
		student=studentService.getStudent(user.getUser_id());
		TopicStatus topicStatus=topicService.getTopicStatus(student.getTopic_id());
		if (topicStatus.getTopicMid()!=0){
			return "home";
		}
		TopicThirdSug topicThirdSug=studentService.getSug(user.getUser_id());
		Report report = topicService.getTopicReport(student.getTopic_id());
		session.put("topicThirdSug",topicThirdSug);
		session.put("report",report);
		return "mid";
	}
	public String midRead(){
		return "midRead";
	}
	public String topFinal(){
		Map session =ActionContext.getContext().getSession();
		User user=(User)session.get("user");
		student = studentService.getStudent(user.getUser_id());
		TopicStatus topicStatus = studentService.getStatus(student);
		if (topicStatus.getTopicFinal()!=0){
			return "home";
		}
		TopicFinalInfo topicFinalInfo = studentService.getFinalInfo(student);
		TopicThirdSug topicThirdSug = studentService.getSug(user.getUser_id());
		session.put("status", RoleUtils.covent(topicStatus.getTopicFinal()));
		session.put("topicFinalInfo", topicFinalInfo);
		session.put("topicThirdSug", topicThirdSug);
		return "final";
	}
	public String change() {
		return "change";
	}
	public String finalSave(){
		Map session=ActionContext.getContext().getSession();
		User user=(User)session.get("user");
		student=studentService.getStudent(user.getUser_id());
		System.out.println("word:" + wordContentType + ",pdf:" + pdfContentType);
		studentService.commitFinal(student, word, pdf, wordFileName, pdfFileName);
		return "home";
	}

}
