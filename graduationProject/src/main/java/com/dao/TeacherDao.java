package com.dao;

import com.beans.Student;
import com.beans.Teacher;

import java.util.List;

public interface TeacherDao {

	public void saveTeacher(Teacher teacher) throws Exception;
	
	public List queryAllTeacher() throws Exception;

	public void updateTeacher(Teacher teacher) throws Exception;

	
}
