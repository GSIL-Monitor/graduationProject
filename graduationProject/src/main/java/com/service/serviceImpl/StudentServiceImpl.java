package com.service.serviceImpl;

import com.beans.Student;

import com.beans.User;
import com.dao.StudentDao;
import com.dao.UserDao;
import com.opensymphony.xwork2.ActionContext;
import com.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by wuhao on 16/4/17.
 */
public class StudentServiceImpl implements StudentService{
    private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    private StudentDao studentDao;

    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public StudentDao getStudentDao() {
        return studentDao;
    }

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public void update(Student student)  {
        try {
            User user = (User)ActionContext.getContext().getSession().get("user");
            student.setUid(user.getUser_id());
            studentDao.updateStudent(student);
        }catch (Exception e){
            logger.error(e.getMessage());
        }

    }

    public void add(Student student,User user) {
        try {
            user.setPassword("123456");
            user.setType(1);
            student.setUid(user.getUser_id());
            System.out.println(student.toString());
            studentDao.saveStudent(student);
            userDao.saveUser(user);
        }catch (Exception e){
            logger.error(e.getMessage());
        }
    }

    public List queryall() {
        List list=new ArrayList();
        try {
            list=studentDao.queryAllStudents();
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return list;
    }

    public Student getStudent(String uid) {
        Student student=new Student();
        try {
            student=studentDao.getStudent(uid);
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return student;
    }
}
