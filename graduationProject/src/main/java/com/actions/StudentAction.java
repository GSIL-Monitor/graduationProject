package com.actions;

import com.beans.Student;
import com.beans.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.StudentService;
import com.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class StudentAction extends ActionSupport {

	private Student student;

	private StudentService studentService;

	private static final Logger logger = LoggerFactory.getLogger(StudentAction.class);

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
		session.put("student",student);
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

}
