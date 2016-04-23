package com.actions;

import com.beans.Student;
import com.beans.Teacher;
import com.opensymphony.xwork2.ActionSupport;
import com.service.StudentService;
import com.service.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TeacherAction extends ActionSupport {

	private Teacher teacher;

	private TeacherService teacherService;

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
		return "home";
	}
	public String update(){
		System.out.println("test:"+teacher.toString());
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
		return "message";
	}
	public String choice(){
		return "choice";
	}
	public String begin(){
		return "begin";
	}
	public String beginRead(){
		return "beginRead";
	}
	public String mid(){
		return "mid";
	}
	public String midRead(){
		return "midRead";
	}
	public String topFinal(){
		return "final";
	}
	public String change() {
		return "change";
	}
	public String process(){
		return "process";
	}
	public String add(){
		return "add";
	}
	public String studentSelect (){
		return "studentSelect";
	}
	public String studentTopic(){
		return "studentTopic";
	}
	public String updateTopic() {
		return "update";
	}

}
