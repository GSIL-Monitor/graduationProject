package com.dao;

import com.beans.Student;
import com.beans.User;

import java.util.List;

public interface StudentDao {

	public void saveStudent(Student student) throws Exception;
	
	public List queryAllStudents() throws Exception;

	public void updateStudent(Student student) throws Exception;

	
}
