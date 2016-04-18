package com.actions;

import com.beans.Student;
import com.beans.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.StudentService;
import com.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

	public String update(){
		studentService.update(student);
		return SUCCESS;
	}


	
}
