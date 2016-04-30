package com.service;

import com.beans.*;

import java.util.List;

/**
 * Created by wuhao on 16/4/16.
 */
public interface TeacherService {

    public void update(Teacher teacher) ;

    public void add(Teacher teacher,User user) ;

    public Teacher getTeacherByteacherId(String teacher_id);

    public Teacher getTeacherByUid(String uid);

    public void addPer(TopicCheckProcess topicCheckProcess);

    public TopicCheckProcess getPer();

    public List queryall() ;

    public void lock(Teacher teacher);

    public List getCheckList(String teacher_id,String statusSql);

    public List getProcessList(String teacher_id);
}
