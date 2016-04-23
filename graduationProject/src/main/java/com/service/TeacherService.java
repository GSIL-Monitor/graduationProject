package com.service;

import com.beans.Student;
import com.beans.Teacher;

import java.util.List;

/**
 * Created by wuhao on 16/4/16.
 */
public interface TeacherService {

    public void update(Teacher teacher) ;

    public void add(Teacher teacher) ;

    public List queryall() ;

}
