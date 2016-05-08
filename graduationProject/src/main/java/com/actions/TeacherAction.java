package com.actions;

import com.beans.*;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.MessageService;
import com.service.StudentService;
import com.service.TeacherService;
import com.service.TopicService;
import com.utils.RoleUtils;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.util.List;
import java.util.Map;

public class TeacherAction extends ActionSupport {

	private InputStream inputStream;

	private Teacher teacher;

	private Topic topic;

	private String topic_id;

	private TeacherService teacherService;

	private StudentService studentService;

	private TopicService topicService;

	private MessageService messageService;

	private long student_id;

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

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public long getStudent_id() {
		return student_id;
	}

	public void setStudent_id(long student_id) {
		this.student_id = student_id;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

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

	public TeacherService getTeacherService() {
		return teacherService;
	}

	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

	private static final Logger logger = LoggerFactory.getLogger(TeacherAction.class);

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public String home(){
		Map session=ActionContext.getContext().getSession();
		User user=(User)session.get("user");
		teacher=teacherService.getTeacherByUid(user.getUser_id());
		TopicCheckProcess topicCheckProcess=teacherService.getPer();
		SumBean sumBean=topicService.count(teacher);
		session.put("topicCheckProcess", topicCheckProcess);
		session.put("sumBean", sumBean);
		return "home";
	}
	public String update(){
		teacherService.update(teacher);
		return SUCCESS;
	}
	public String info(){
		return "info";
	}
	public String messageDetail(){
		return "messageDetail";
	}
	public String message(){
		List messageList=messageService.queryAllMessages();
		ActionContext.getContext().getSession().put("messageList",messageList);
		return "message";
	}
	public String choice(){
		return "choice";
	}
	public String begin(){
		String statusSql="topicStatus.topicBegin=1";
		Map session=ActionContext.getContext().getSession();
		User user=(User)session.get("user");
		Teacher teacher=teacherService.getTeacherByUid(user.getUser_id());
		List checkList =teacherService.getCheckList(teacher.getTeacher_id(),statusSql);
		session.put("checkList", checkList);
		return "begin";
	}
	public String beginRead(){
		String statusSql="topicStatus.topicBegin in (1,2)";
		Map session=ActionContext.getContext().getSession();
		User user=(User)session.get("user");
		Teacher teacher=teacherService.getTeacherByUid(user.getUser_id());
		List checkList =teacherService.getCheckList(teacher.getTeacher_id(),statusSql);
		session.put("checkList", checkList);
		return "beginRead";
	}
	public String mid(){
		String statusSql="topicStatus.topicMid=1";
		Map session=ActionContext.getContext().getSession();
		User user=(User)session.get("user");
		Teacher teacher=teacherService.getTeacherByUid(user.getUser_id());
		List checkList =teacherService.getCheckList(teacher.getTeacher_id(),statusSql);
		session.put("checkList", checkList);
		return "mid";
	}
	public String midRead(){
		String statusSql="topicStatus.topicMid in (1,2)";
		Map session=ActionContext.getContext().getSession();
		User user=(User)session.get("user");
		Teacher teacher=teacherService.getTeacherByUid(user.getUser_id());
		List checkList =teacherService.getCheckList(teacher.getTeacher_id(),statusSql);
		session.put("checkList", checkList);
		return "midRead";
	}
	public String topFinal(){
		String statusSql="topicStatus.topicFinal=1";
		Map session=ActionContext.getContext().getSession();
		User user=(User)session.get("user");
		Teacher teacher=teacherService.getTeacherByUid(user.getUser_id());
		List checkList =teacherService.getCheckList(teacher.getTeacher_id(),statusSql);
		session.put("checkList", checkList);
		return "final";
	}
	public String change() {
		return "change";
	}
	public String process(){
		Map session=ActionContext.getContext().getSession();
		User user=(User)session.get("user");
		teacher=teacherService.getTeacherByUid(user.getUser_id());
		List processList=teacherService.getProcessList(teacher.getTeacher_id());
		session.put("processList", processList);
		return "process";
	}
	public String add(){

		return "add";
	}
	public String studentSelect (){
		Map session=ActionContext.getContext().getSession();
		Student student=studentService.getStudentByid(student_id);
		session.put("student",student);
		String sqlwhere="topic.topic_id not in (select student.topic_id from Student as student where student.status=1)";
		List topicList=topicService.queryAllTopicBymajorName(student.getMajorName(),sqlwhere);
		session.put("topicList",topicList);
		return "studentSelect";
	}
	public String studentTopic(){
		Map session=ActionContext.getContext().getSession();
		User user=(User)session.get("user");
		Teacher teacher=teacherService.getTeacherByUid(user.getUser_id());
		List<Student> studentList=studentService.queryallByMajorName(teacher.getMajor_name());
		session.put("studentList",studentList);
		return "studentTopic";
	}
	public String updateTopic() {
		String sqlWhere="topic.status in (1,0)";
		Map session=ActionContext.getContext().getSession();
		User user=(User)session.get("user");
		Teacher teacher=teacherService.getTeacherByUid(user.getUser_id());
		List topicList=topicService.getTopicByteacherId(teacher.getTeacher_id(), sqlWhere);
		session.put("topicList",topicList);
		return "update";
	}

	public String updateTopicDetail() {
		ActionContext.getContext().getSession().put("topic_id",topic_id);
		return "updateDetail";
	}
	public String updateTopicDetailVal() {
		topic_id=(String)ActionContext.getContext().getSession().get("topic_id");
		topic=topicService.getTopicByTopicId(topic_id);
		TopicChange topicChange=new TopicChange(topic);
		String topicJson=RoleUtils.transcoding(JSONObject.fromObject(topicChange).toString());
		inputStream = new StringBufferInputStream(topicJson);
		return SUCCESS;
	}



}
