package com.dao;

import com.beans.Student;
import com.beans.User;

import java.util.List;

public interface StudentDao {

	public void saveStudent(Student student) throws Exception;
	
	public List queryAllStudents() throws Exception;

	public void updateStudent(Student student) throws Exception;

	public Student getStudent(String uid) throws Exception;

	public Student getStudentByid(long id) throws Exception;

	public Student getStudentByTopicId(String topic_id) throws Exception;

	public List queryAllByMajorName(String majorName) throws Exception;

	public void lockStudent(Student student) throws Exception;

	public void selectTopic(Student student) throws Exception;


}
