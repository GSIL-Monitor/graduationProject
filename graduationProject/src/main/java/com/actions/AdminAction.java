package com.actions;

import com.beans.*;
import com.opensymphony.xwork2.ActionSupport;
import com.service.StudentService;
import com.service.TeacherService;
import com.service.TopicService;
import com.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AdminAction extends ActionSupport {
	private static final Logger logger = LoggerFactory.getLogger(AdminAction.class);
	
	private UserService userService;

	private TopicService topicService;

	private TeacherService teacherService;

	private StudentService studentService;

	private Student student;

	private User user;

	private TopicProcess topicProcess;

	private int is_pass;

	private TopicCheckProcess topicCheckProcess;

	public TopicCheckProcess getTopicCheckProcess() {
		return topicCheckProcess;
	}

	public int getIs_pass() {
		return is_pass;
	}

	public void setIs_pass(int is_pass) {
		this.is_pass = is_pass;
	}

	public void setTopicCheckProcess(TopicCheckProcess topicCheckProcess) {
		this.topicCheckProcess = topicCheckProcess;
	}

	public TopicProcess getTopicProcess() {
		return topicProcess;
	}

	public void setTopicProcess(TopicProcess topicProcess) {
		this.topicProcess = topicProcess;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public TopicService getTopicService() {
		return topicService;
	}

	public void setTopicService(TopicService topicService) {
		this.topicService = topicService;
	}

	public TeacherService getTeacherService() {
		return teacherService;
	}

	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	public String stuAdd(){
		studentService.add(student,user);
		return "home";
	}
	public String stuDelete(){
		return "STU_DELETE";
	}
	public String teaDelete(){
		return "TEA_DELETE";
	}
	public String stuCreate(){
		return "STU_CREATE";
	}
	public String stuUpdate(){
		return "STU_UPDATE";
	}
	public String teaCreate(){
		return "TEA_CREATE";
	}
	public String teaUpdate(){
		return "TEA_UPDATE";
	}
	public String studentPer() {
		return "STUDENT_PER";
	}
	public String teacherPer(){
		return "TEACHER_PER";
	}
	public String stuPer() {
		System.out.println(topicProcess.toString());
		return "home";
	}
	public String teaPer() {
		System.out.println(topicCheckProcess.toString());
		return "home";
	}
	public String change() {
		return "change";
	}
	public String topicCheck() {
		System.out.print("is_pass:"+is_pass);
		return "topicCheck";
	}
	public String check() {
		return "check";
	}
	public String messageCreate() {
		return "MSG_CRE";
	}
	public String msgCreate() {
		return "CRE_MSG";
	}
	public String msgDelete() {
		return "MSG_DEL";
	}
	public String msgList() {
		return "MSG_LIST";
	}
	public String home() {
		return "home";
	}
}
