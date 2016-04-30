package com.service;

import com.beans.*;

import java.io.File;
import java.util.List;

/**
 * Created by wuhao on 16/4/16.
 */
public interface StudentService {

    public void update(Student student) ;

    public void selectTopic(Student student,Topic topic) ;

    public void add(Student student,User user) ;

    public Student getStudent(String uid);

    public Student getStudentByid(long id);

    public void addPer(TopicProcess topicProcess);

    public TopicProcess getPer();

    public List queryall() ;

    public void lock(Student student);

    public List queryallByMajorName(String majorName);

    public TopicThirdSug getSug(String uid);

    public TopicFinalInfo getFinalInfo(Student student);

    public TopicStatus getStatus(Student student);

    public void commitFinal(Student student,File word,File pdf,String wordName,String pdfName);

}
