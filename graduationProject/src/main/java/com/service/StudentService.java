package com.service;

import com.beans.Student;
import com.beans.User;

import java.util.List;

/**
 * Created by wuhao on 16/4/16.
 */
public interface StudentService {

    public void update(Student student) ;

    public void add(Student student,User user) ;

    public Student getStudent(String uid);

    public List queryall() ;

}
